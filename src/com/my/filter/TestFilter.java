/**
* @(#)com.my.filter.TestFilter.java
* 南京中兴软创科技有限责任公司
* @date 2014-1-10
*/
package com.my.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** 
 * 
 * @author <a href="tong.hao@zte.com.cn">童浩</a>
 * @version 1.0 
 * @since 2014-1-10 上午9:37:26 
 */

public class TestFilter implements Filter {
	
	int i = 1;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("---" + i++);
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

		System.out.println("TestFilter.initaaab()");
		
		FileChannel channel = null;
		FileLock lock = null;
		try {
//			对于一个只读文件通过任意方式加锁时会报NonWritableChannelException异常
//			同样对写通道通过有参lock()方式加锁时也会报NonReadableChannelException异常
//			无参lock()默认为独占锁，不会报NonReadableChannelException异常，因为独占就是为了写
//			所谓的共享也只能读共享，写是独占的，共享锁控制的代码只能是读操作
//			channel = new FileOutputStream("logfile.txt",true).getChannel();
			
			//RandomAccessFile raf = new RandomAccessFile("E:/a.txt","rw");
			//String temp = System.getProperty("java.io.tmpdir") + "randomLockFile.txt";
			String temp = System.getProperty("user.home") + "randomLockFile.txt";
			
			RandomAccessFile raf = new RandomAccessFile(temp,"rw");
//			RandomAccessFile raf = new RandomAccessFile("C:\\DOCUME~1\\ADMINI~1\\LOCALS~1\\Temp\\randomLockFile.txt","rw");
			raf.seek(raf.length());//raf在文件末尾追加内容的处理
			channel = raf.getChannel();
			
//			获得锁方法一lock，阻塞的方法，当文件锁不可用时，当前进程会被挂起
//			lock = channel.lock(0L, Long.MAX_VALUE, true);//共享锁，有写操作会报异常
			//lock = channel.lock();//独占锁
			
//			获得锁方法二trylock，非阻塞的方法，当文件锁不可用时，tryLock()会得到null值
/*			do {
				lock = channel.tryLock();
			} while(null == lock);*/
			
			lock = channel.tryLock();
			
			if(lock != null) {
				System.out.println("get lock");
			} else {
				System.out.println("can not get lock");
				
			}

			System.out.println("lock");
			
			
			
//			互斥操作
//			ByteBuffer sendBuffer=ByteBuffer.wrap((new Date()+" 写入\n").getBytes());
//			channel.write(sendBuffer);
			//Thread.sleep(5000);
			
//			Thread.sleep(20000);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		} finally {
			/*if(lock != null) {
				try {
					lock.release();
					lock = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(channel != null) {
				try {
					channel.close();
					channel = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}*/
		}
	}

}

package com.my.other;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestGetFile {

	/**
	 * 方法的简述.
	 * <p>
	 * 方法的详细说明第一行<br>
	 * 方法的详细说明第二行
	 * 
	 * @param 参数
	 * @exception 异常描述
	 * @return 没有返回值
	 */

	public static void main(String[] args) {
		down(new File("f:/temp/a.jpg"),
				"http://www.baidu.com");
/*		down(new File("f:/temp/a.jpg"),
				"http://g.hiphotos.baidu.com/baike/s%3D220/sign=d866a8dace1b9d168ec79d63c3dfb4eb/a686c9177f3e6709679d7ffa3bc79f3df8dc5511.jpg");
*/
		
		while ((fromNode) && (fromNode != startNode)) {
			if ((fromNode.label) && (fromNode.label.search(searchStr) != -1))
				return (fromNode);

			if (!direction) {
				if (fromNode == -1) {
					if (startNode == this.htmlNode)
						break;
					fromNode = this.htmlNode.childNodes[0];
				}
				if ((fromNode.unParsed)
						&& (this.findStrInXML(fromNode.unParsed.d, "text",
								searchStr)))
					this.reParse(fromNode);
				fromNode = this._getNextNode(fromNode);
				if (fromNode == -1)
					fromNode = this.htmlNode;
			} else {
				var z2 = this._getPrevNode(fromNode);
				if (z2 == -1)
					z2 = this._lastChild(this.htmlNode);
				if ((z2.unParsed)
						&& (this.findStrInXML(z2.unParsed.d, "text", searchStr))) {
					this.reParse(z2);
					fromNode = this._getPrevNode(fromNode);
				} else
					fromNode = z2;
				if (fromNode == -1)
					fromNode = this._lastChild(this.htmlNode);
			}
		}
	}

	public static void down(File f, String url) {
//		byte[] buffer = new byte[8 * 1024];
		char[] buffer = new char[2 * 102];
		URL u = null;
		URLConnection connection = null;
		try {
			u = new URL(url);
			connection = u.openConnection();
		} catch (Exception e) {
			System.out.println("ERR:" + url);
			return;
		}
		connection.setReadTimeout(100000);
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			f.createNewFile();
			is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "gbk");
			fos = new FileOutputStream(f);
			int len = 0;
			while ((len = isr.read(buffer)) != -1) {
				//fos.write(buffer, 0, len);
				System.out.println("+++++++++++++" + buffer.length);
				System.out.print(buffer);
				
			}
/*			while ((len = is.read(buffer)) != -1) {
				//fos.write(buffer, 0, len);
				System.out.write(buffer, 0, len);
				
			}
*/
		} catch (Exception e) {
			e.printStackTrace();
			f.delete();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		buffer = null;
		// System.gc();
		System.out.println("done");
	}

}

package com.my.servlet;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class TestServlet extends HttpServlet {
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#getLastModified(javax.servlet.http.HttpServletRequest)
	 */
	/*@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		//return 2000;
		String path = req.getServletContext().getRealPath("index.jsp");
		System.out.println(path);
		return new File(path).lastModified();
	}
*/
	private static final long serialVersionUID = 1L;
	
	int j = 10;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // 对于静态资源,会自动识别是否修改过,返回200或者304
    // 对于经过servlet处理过的资源,需要getLastModified来判断
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemoteHost());
		System.out.println(request.getRemoteUser());
		System.out.println(request.getLocalAddr());
		
		System.out.println("---");
		
		System.out.println(request.getRealPath("/WEB-INF/lib"));
		File f = new File(request.getRealPath("/WEB-INF/lib"));
		System.out.println(f.exists());
		System.out.println(f.getAbsolutePath());

		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress().toString());//获得本机IP

		System.out.println("+++");
		
		System.out.println("TestServlet.doGet()");
		/*request.setAttribute("name1", "tom");
		// <jsp:include page=""></jsp:include>
//		response.getWriter().println("welcome");
		doConnect(request);
		getServletContext().getRequestDispatcher("/index.jsp").include(request, response);// 不仅仅是静态的html文件,其他资源也可以
//		getServletContext().getRequestDispatcher("/index.html").include(request, response);
*/
		System.out.println("+++" + j++);
		int x = 0;
		/*ServletOutputStream out = response.getOutputStream();
		for(int i = 0; i<5; i++) {
			out.print("shit" + x++);
			out.flush();
			System.out.println("shit" + x);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}
	
	private void doConnect(HttpServletRequest request) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user");// stmt.execute返回值是boolean类型
			int i = 0;
			while(rs.next()) {
				System.out.println(rs.getString(2));
				request.setAttribute("user" + i++, rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs = null;
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs = null;
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = null;
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import until.DataBaseBean;

public class Ajax_Servlet extends HttpServlet{

	public void init() throws ServletException {
		/*
		 * 构造器调用之后马上被调用，用来初始化Servlet，只会调用一次
		 */
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 转发到dopost下面进行处理请求
		this.doPost(request, response);
		/*
		 * 为get时service()方法
		 */
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// getparameter()能获取用户发送的请求参数,()里为jsp发送参数的名称
		System.out.println("hello");
		String id = request.getParameter("id");
		System.out.println(id);
		String password = request.getParameter("password");
		String login_flag = null;
		// 实例化DataBaseConnection
		DataBaseBean dbc = new DataBaseBean();
		ResultSet rs;
		Connection conn;
		PreparedStatement pstmt;

		// String driver = "oracle.jdbc.driver.OracleDriver";
	       // String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	      //  String url="jdbc:oracle:thin:@(description=(address=(protocol=tcp)(port=1521)(host=localhost)(PORT = 1521))(connect_data=(SERVER = DEDICATED)(service_name=XE)))";
	      //  String username = "Chao";
	     //   String orpassword = "123456";
		try {
		
			//  Class.forName(driver);
	       //  conn = DriverManager.getConnection(url, username, orpassword);
			conn=dbc.getConnection();
			pstmt = conn.prepareStatement( "SELECT * FROM WORKER WHERE WORKERID=? AND WORKPWD=?");
			//为pstmt里的？赋值
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			//执行查询方法
			rs = pstmt.executeQuery();
			if (rs.next()) {
				login_flag = "true";
			} else {
				login_flag = "false";
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		response.setCharacterEncoding("UTF-8"); // 转为中文格式
		PrintWriter out = response.getWriter();
		//往ajax提交结果
		out.print(login_flag);
		out.flush();
		out.close();
	}

	public void destroy() {
		/*
		 * Servlet对象销毁前(WEB项目卸载时)调用，用来做一些收尾工作，释放资源。
		 */
	}

}

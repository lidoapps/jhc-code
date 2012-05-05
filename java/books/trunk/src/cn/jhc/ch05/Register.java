/*
 * cn.jhc.ch05.Register.java
 * 2007-6-13
 * 第5章的Java示例，验证登录用户的信息
 */
package cn.jhc.ch05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jhc.ch05.User;


public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public Register() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
		//获取session
		HttpSession session = request.getSession();
		//获取输入的数据
		String pass = request.getParameter("password");
		String user = request.getParameter("loginName");

		//创建业务对象，验证登录
		CheckLogin ck =new CheckLogin();
		
		if (ck.validate(user, pass)) {
			System.out.println("登录成功!");
			User logineduser = new User(user, pass);
			session.setAttribute("LOGINED_USER", logineduser);
			
			//合法转浏览书籍页面
			//失败，重新登录
			response.sendRedirect("/books/ch05/books.jsp");
		} else {
			System.out.println("登录失败!");
			response.sendRedirect("/books/ch05/register2.html");
		}
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}

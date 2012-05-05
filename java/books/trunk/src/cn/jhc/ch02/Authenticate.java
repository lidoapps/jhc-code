package cn.jhc.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


public class Authenticate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Authenticate() {
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

		// 将输入转换为中文
		request.setCharacterEncoding("GBK");
		// 设置输出为中文
		response.setContentType("text/html;charset=GBK");
		
		String pass = request.getParameter("password");
		String user = request.getParameter("loginName");

		//ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = null;
		if (user.equals("accp") && pass.equals("accp")) {
			System.out.println("登录成功!");
			request.setAttribute("loginname", user);
			dispatcher = request.getRequestDispatcher("/ch02/ok.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("../ch02/register.jsp");
			
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

package cn.jhc.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.text.*;


public class HelloServlet extends HttpServlet {

	/**
	 * 构造方法.
	 */
	public HelloServlet() {
		super();
	}

	/**
	 * 用于释放资源 <br>
	 */
	public void destroy() {
		super.destroy();
		System.out.println("释放系统资源时,destroy()方法被调用!");// Just puts "destroy" string in log
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("处理请求时，doGet()方法被调用。");
		//将日期转换为特定格式的字符串
		Date now = new java.util.Date();
		SimpleDateFormat formater = new java.text.SimpleDateFormat(
				"yyyy年MM月dd日");
		String strCurrentTime = formater.format(now);

		//设定输出内容为html,字符集为中文
		response.setContentType("text/html;charset=GBK");
		
		//使用打印输出流，向客户端输出信息
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("你好!ACCP "+strCurrentTime);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	/**
	 * 初始化方法 <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		 System.out.println("初始化时，init()方法被调用!");
	}

}

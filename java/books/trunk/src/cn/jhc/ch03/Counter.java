/*
 * cn.jhc.ch03.Counter.java
 * Y2javaee的ch03的示例，演示页面计数
 */
package cn.jhc.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Counter extends HttpServlet {


	private static final long serialVersionUID = 1L;


	/**
	 * Constructor of the object.
	 */
	public Counter() {
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
		// 输出中文
		response.setContentType("text/html;charset=GBK");
		
		//创建session
		HttpSession session = request.getSession(true);
		Object count = session.getAttribute("COUNTER");
		int counter = 0;
		if (count == null) {
			counter = 1;
			//将第一次计数存入session
			session.setAttribute("COUNTER", new Integer(1));
		} else {
			counter = ((Integer) count).intValue();
			counter++;//计数加一
			//将计数存入session
			session.setAttribute("COUNTER", new Integer(counter));
		}
		PrintWriter out = response.getWriter();

		// 输出信息
		out.println(" 欢迎你" + counter + "次访问ACCP网站!");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}

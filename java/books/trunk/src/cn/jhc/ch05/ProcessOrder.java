/*
 * cn.jhc.ch05.ProcessOrder.java
 * 2007-6-13
 * 第5章的Java示例，处理用户的订单
 */
package cn.jhc.ch05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProcessOrder extends HttpServlet {


	private static final long serialVersionUID = 1L;


	/**
	 * Constructor of the object.
	 */
	public ProcessOrder() {
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
		// 处理中文输入
		request.setCharacterEncoding("GBK");
		// 获取session
		HttpSession session = request.getSession();

		// 获取输入的表单数据
		String username = request.getParameter("username");// 用户名
		String zipcode = request.getParameter("zipcode");// 邮编
		String phone = request.getParameter("phone");// 电话
		String creditcard = request.getParameter("creditcard");// 信用卡
		
		//读出总的价钱
		double total = ((Double)session.getAttribute("total")).doubleValue();
		OrderOperation op = new OrderOperation();
		op.saveOrder(username, zipcode, phone, creditcard, total);
		request.getRequestDispatcher("/ch05/bye.jsp").forward(request,response);
		session.invalidate();
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}

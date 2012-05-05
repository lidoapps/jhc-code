/*
 * cn.jhc.ch09.ProcessOrder.java
 * 2007-6-16
 * 第9章的Java示例，演示Web服务的调用程序
 */
package cn.jhc.ch09;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

public class ProcessOrder extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取会话
		HttpSession session = request.getSession();

		// 读取订单的参数
		String creditcard = request.getParameter("creditcard");
		double total = ((Double) session.getAttribute("total")).doubleValue();

		// 创建服务的元数据
		Service serviceModel = new ObjectServiceFactory()
				.create(IProcessCredit.class);
		System.out.println("返回了服务的模型.");

		// 创建服务的代理
		XFire xfire = XFireFactory.newInstance().getXFire();
		XFireProxyFactory factory = new XFireProxyFactory(xfire);

		String serviceUrl = "http://localhost:8088/books/services/CreditCard";// 服务的地址

		IProcessCredit client = null;
		try {
			client = (IProcessCredit) factory.create(serviceModel, serviceUrl);
		} catch (MalformedURLException e) {
			System.out.println("客户端调用异常: " + e.toString());
		}

		// 调用服务
		int serviceResponse = 0;
		try {
			serviceResponse = client.creditProcess(creditcard, total);
			System.out.println("WsClient.callWebService(): status="
					+ serviceResponse);
		} catch (Exception e) {
			System.out.println("WsClient.callWebService(): EXCEPTION: "
					+ e.toString());
		}
		if (serviceResponse == 1) {
			request.getRequestDispatcher("/ch09/bye.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("/ch09/error.jsp").forward(request,
					response);
		}
		session.invalidate();
	}

}

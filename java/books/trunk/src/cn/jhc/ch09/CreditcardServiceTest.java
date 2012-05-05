/*
 * cn.jhc.ch09.CreditcardServiceTest.java
 * 2007-6-16
 * 第9章的Java示例，演示Web服务的单元测试程序
 */
package cn.jhc.ch09;

import java.net.MalformedURLException;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.aegis.AbstractXFireAegisTest;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.ServiceFactory;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.service.invoker.ObjectInvoker;

public class CreditcardServiceTest extends AbstractXFireAegisTest {
	/**
	 * 初始化
	 */
	public void setUp() throws Exception {
		super.setUp();

		// Register the web service.
		XFire xfire = getXFire();
		ServiceFactory factory = new ObjectServiceFactory(xfire
				.getTransportManager(), null);

		Service service = factory.create(IProcessCredit.class);
		service.setProperty(ObjectInvoker.SERVICE_IMPL_CLASS,
				ProcessCreditCard.class);
		xfire.getServiceRegistry().register(service);
	}

	/**
	 * 客户端测试
	 * 
	 * @throws Exception
	 */
	public void testCreditProcess() throws Exception {
		// Create a metadata of the service
		Service serviceModel = new ObjectServiceFactory()
				.create(IProcessCredit.class);
		System.out.println("callSoapServiceLocal(): got service model.");

		// Create a proxy for the deployed service
		XFire xfire = XFireFactory.newInstance().getXFire();
		XFireProxyFactory factory = new XFireProxyFactory(xfire);

		String serviceUrl = "http://localhost:8080/books/services/CreditCard";

		IProcessCredit client = null;
		try {
			client = (IProcessCredit) factory.create(serviceModel, serviceUrl);
		} catch (MalformedURLException e) {
			System.out.println("WsClient.callWebService(): EXCEPTION: "
					+ e.toString());
		}

		// Invoke the service
		int serviceResponse = 0;
		try {
			serviceResponse = client.creditProcess("12345678901", 200);

			assertEquals("程序运行错误", 1, serviceResponse);

		} catch (Exception e) {
			System.out.println("WsClient.callWebService(): EXCEPTION: "
					+ e.toString());
		}
		System.out.println("WsClient.callWebService(): status="
				+ serviceResponse);

	}
}

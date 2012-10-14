package cn.jhc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void test() {
		InvocationHandler handler = new HelloHandler(new EnglishHello());
		Hello proxy = (Hello) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), 
				new Class[] {Hello.class}, handler);
		proxy.sayHello();
		proxy.sayWelcome();
		
		InvocationHandler handler2 = new HelloHandler(new ChineseHello());
		Hello proxy2 = (Hello) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
				new Class[] {Hello.class}, handler2);
		proxy2.sayHello();
		proxy2.sayWelcome();
	}

}

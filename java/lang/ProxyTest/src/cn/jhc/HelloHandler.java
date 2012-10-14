package cn.jhc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloHandler implements InvocationHandler {
	
	private Hello original;
	
	public HelloHandler(Hello original) {
		this.original = original;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("You are calling object: " + original);
		System.out.println("The method you are calling is: " + method.getName());
		Object obj = method.invoke(original, args);
		System.out.println("Calling ended.");
		System.out.println("");
		return obj;
	}
}

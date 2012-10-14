package cn.jhc;

public class EnglishHello implements Hello {

	@Override
	public void sayHello() {
		System.out.println("Hello World!");
	}

	@Override
	public void sayWelcome() {
		System.out.println("Welcome!");
	}

}

package cn.jhc;

public class ChineseHello implements Hello {

	@Override
	public void sayHello() {
		System.out.println("您好！");
	}

	@Override
	public void sayWelcome() {
		System.out.println("欢迎！");
	}

}

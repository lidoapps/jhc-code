package cn.jhc.ch07;

public class Simplebean {

	private String name;
	private int age;

	public Simplebean() {
		System.out.println("调用无参构造方法，创建实例!!!");
	}

	public Simplebean(String name, float age) {
		System.out.println("调用有参构造方法，创建实例，并为对象属性赋值!!!");
	}

	public String getName() {
		System.out.println("调用了getName()方法，获取name值");
		return name;
	}

	public void setName(String username) {
		name = username;
		System.out.println("调用了setName()方法，设置name值");
	}

	public int getAge() {
		System.out.println("调用了getAge()方法，获取age值。");
		return age;
	}

	public void setAge(int userage) {
		age = userage;
		System.out.println("调用了setAge()方法，设置age值");
	}

}

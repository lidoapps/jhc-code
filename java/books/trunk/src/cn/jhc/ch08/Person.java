/*
 * cn.jhc.ch08.Person.java
 * 2007-6-16
 * 第8章的Java示例，演示EL隐示对象
 */
package cn.jhc.ch08;

public class Person {
	private String name;// 姓名

	private int age;// 年龄

	/**
	 * 
	 * 构造方法
	 */
	public Person() {
		setName("ZhangSan");
		setAge(21);
	}

	/**
	 * 设定姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 读取姓名
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设定年龄
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 读取年龄
	 * @return
	 */
	public int getAge() {
		return age;
	}
}

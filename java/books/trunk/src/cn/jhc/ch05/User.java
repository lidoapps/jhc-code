/*
 * cn.jhc.ch05.User.java
 * 2007-6-13
 * 第5章的Java示例，存储登录用户的信息
 */
package cn.jhc.ch05;

public class User {
	private String name;// 用户名

	private String password;// 密码

	/**
	 * 返回用户名
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设定用户名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 返回密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设定密码
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 构造函数
	 * 
	 * @param name
	 * @param password
	 */
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
}

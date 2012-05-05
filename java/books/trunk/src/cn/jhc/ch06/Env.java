/*
 * cn.jhc.ch06.Env.java
 * Y2javaee的ch06的示例，用于演示属性文件
 */
package cn.jhc.ch06;

import java.io.InputStream;
import java.util.Properties;

public final class Env extends Properties {

	private static final long serialVersionUID = 1L;

	private static Env instance;

	/**
	 * 公有的获取实例的方法
	 * @return Env 实例
	 */
	public static Env getInstance() {
		if (instance != null) {
			return instance;
		} else {
			makeInstance();
			return instance;
		}
	}

	/**
	 * 同步的创建实例方法
	 *
	 */
	private static synchronized void makeInstance() {
		if (instance == null) {
			instance = new Env();
		}
	}
	
	/**
	 * 私有的构造方法，确保实例的唯一性
	 *
	 */
	private Env() {
		InputStream is = getClass().getResourceAsStream("/db.properties");
		try {
			load(is);
		} catch (Exception e) {
			System.err.println("错误：没有读取属性文件，请确认db.property文件是否存在。");
			return;
		}
	}
}
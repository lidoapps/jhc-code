/*
 * cn.jhc.ch06.DBAccessException.java
 * 2007-6-13
 * 第6章的Java示例，演示Java的自定义异常
 */
package cn.jhc.ch06;

public class DBAccessException extends Exception {

	private static final long serialVersionUID = 1L;

	protected Throwable throwable;

	/**
	 * 构造方法
	 * 
	 * @param message
	 */
	public DBAccessException(String message) {
		super(message);

	}

	/**
	 * 构造方法
	 * 
	 * @param message
	 * @param throwable
	 */
	public DBAccessException(String message, Throwable throwable) {
		super(message);
		this.throwable = throwable;
	}

	/**
	 * 返回底层异常原因
	 * 
	 * @return Throwable
	 */
	public Throwable getCause() {
		return throwable;
	}

}

/*
 * cn.jhc.ch07.Order.java
 * 2007-6-16
 * 第7章的Java示例，JavaBean
 */
package cn.jhc.ch07;

public class Order {
	private String username;// 用户名

	private String zipcode;// 邮编

	private String phone;// 电话

	private String creditcard;// 信用卡

	private double total;// 总额

	/**
	 * 返回信用卡
	 * 
	 * @return
	 */
	public String getCreditcard() {
		return creditcard;
	}

	/**
	 * 设定信用卡
	 * 
	 * @param creditcard
	 */
	public void setCreditcard(String creditcard) {
		System.out.println("set creditcard " + creditcard);
		this.creditcard = creditcard;
	}

	/**
	 * 返回电话
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设定电话
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 返回总额
	 * 
	 * @return
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * 设定总额
	 * 
	 * @param total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * 返回用户名
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设定用户名
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 返回邮编
	 * 
	 * @return
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * 设定邮编
	 * 
	 * @param zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * 构造方法
	 * 
	 * @param username
	 * @param zipcode
	 * @param phone
	 * @param creditcard
	 * @param total
	 */
	public Order(String username, String zipcode, String phone,
			String creditcard, double total) {
		super();
		this.username = username;
		this.zipcode = zipcode;
		this.phone = phone;
		this.creditcard = creditcard;
		this.total = total;
	}

	/**
	 * 不带参数的构造方法
	 * 
	 * @param username
	 * @param zipcode
	 * @param phone
	 * @param creditcard
	 * @param total
	 */
	public Order() {

	}
}

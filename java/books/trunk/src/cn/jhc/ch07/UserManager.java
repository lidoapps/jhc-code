/*
 * cn.jhc.ch07.UserManager.java
 * 2007-6-16
 * 第7章的Java示例，验证登录的JavaBean
 */
package cn.jhc.ch07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.jhc.ch05.ConnectionManager;


public class UserManager {
	private String name;// 用户名

	private String password;// 密码

	private boolean valid = false;// 是否合法

	public UserManager() {

	}

	/**
	 * 验证登录是否正确
	 * 
	 * @return
	 */
	public boolean getValid() {
		Connection con = ConnectionManager.getConnction();
		PreparedStatement pStatement = null;
		String sql = "select * from userinfo where loginname = ?";

		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, getName());
			ResultSet rs = pStatement.executeQuery();
			if (rs.next() && rs.getString("password").equals(getPassword())) {
				System.out.println("登录成功!");
				valid = true;
			} else {
				System.out.println("登录失败!");
				valid = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(con);
		}
		return valid;
	}

	/**
	 * 取出用户名
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设定用户名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取出密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设定密码
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}

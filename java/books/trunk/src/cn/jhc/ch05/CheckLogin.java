/*
 * cn.jhc.ch05.CheckLogin.java
 * 2007-6-13
 * 第5章的Java示例，验证登录用户的信息
 */
package cn.jhc.ch05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jhc.ch05.ConnectionManager;


public class CheckLogin {
	/**
	 * 验证用户
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	public boolean validate(String user, String pass) {
		boolean valid = false;
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;

		try {
			String sql = "select * from userinfo where loginname = ? ";
			Connection con = ConnectionManager.getConnction();
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, user);

			res = pStatement.executeQuery();
			if (res.next() && res.getString("password").equals(pass)) {
				valid = true;
			} else {
				System.out.println("登录失败!");
			}

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}

		return valid;
	}
}

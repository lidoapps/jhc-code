/*
 * cn.jhc.ch05.OrderOperation.java
 * 2007-6-13
 * 第5章的Java示例，将用户的订单存入数据库
 */
package cn.jhc.ch07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.jhc.ch05.ConnectionManager;


public class OrderOperation {
	/**
	 * 插入订单信息到数据库
	 * 
	 * @return
	 */
	public int setOrder(Order order) {
		int result = 0;
		Connection con = null;
		PreparedStatement pStatement = null;

		try {
			con = ConnectionManager.getConnction();
			String strSql = "insert into BookOrder(username,zipcode,phone,"
					+ "creditcard,total) values(?,?,?,?,?)";
			pStatement = con.prepareStatement(strSql);
			pStatement.setString(1, order.getUsername());
			pStatement.setString(2, order.getZipcode());
			pStatement.setString(3, order.getPhone());
			pStatement.setString(4, order.getCreditcard());
			pStatement.setDouble(5, order.getTotal());
			System.out.println(strSql);
			result = pStatement.executeUpdate();
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(con);
		}
		return result;
	}
}

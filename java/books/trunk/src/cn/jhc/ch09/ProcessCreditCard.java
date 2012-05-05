/*
 * cn.jhc.ch09.ProcessCreditCard.java
 * 2007-6-16
 * 第9章的Java示例，演示Web服务
 */
package cn.jhc.ch09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.jhc.ch05.ConnectionManager;


public class ProcessCreditCard implements IProcessCredit{
	public int creditProcess(String creditCard, double total){
		int result = 0;
		Connection con = null;
		PreparedStatement pStatement = null;

		try {
			con = ConnectionManager.getConnction();
			String strSql = "update Account "
					+ "set balance = balance - ? where creditcard = ?";
			pStatement = con.prepareStatement(strSql);
			pStatement.setDouble(1, total);
			pStatement.setString(2, creditCard);
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

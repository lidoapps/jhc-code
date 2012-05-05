/*
 * cn.jhc.ch05.ConnectionManager.java
 * 2007-6-13
 * 第5章的Java示例，演示Java的JDBC的PreparedStatement语句
 */
package cn.jhc.ch05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {


	private static final String DRIVER_CLASS = "com.microsoft.jdbc.sqlserver.SQLServerDriver";

	private static final String DATABASE_URL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=books";

	private static final String DATABASE_USRE = "sa";

	private static final String DATABASE_PASSWORD = "120010";

	/**
	 * 返回连接
	 * 
	 * @return Connection
	 */
	public static Connection getConnction() {
		Connection dbConnection = null;
		try {
			Class.forName(DRIVER_CLASS);
			dbConnection = DriverManager.getConnection(DATABASE_URL,
					DATABASE_USRE, DATABASE_PASSWORD);

			// dbConnection = DriverManager.getConnection(DATASOURCE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnection;
	}

	/**
	 * 关闭连接
	 * 
	 * @param dbConnection
	 *            Connection
	 */
	public static void closeConnection(Connection dbConnection) {
		try {
			if (dbConnection != null && (!dbConnection.isClosed())) {
				dbConnection.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

	}

	/**
	 * 关闭结果集
	 * 
	 * @param res
	 *            ResultSet
	 */
	public static void closeResultSet(ResultSet res) {
		try {
			if (res != null) {
				res.close();
				res = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭语句
	 * 
	 * @param pStatement
	 *            PreparedStatement
	 */

	public static void closeStatement(PreparedStatement pStatement) {
		try {
			if (pStatement != null) {
				pStatement.close();
				pStatement = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

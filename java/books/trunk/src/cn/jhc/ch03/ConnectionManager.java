/*
 * cn.jhc.ch03.ConnectionManager.java
 * 2007-6-12
 * 第3章的Java示例，演示Java的JDBC的连接管理
 */
package cn.jhc.ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private static final String DRIVER_CLASS;

	private static final String DATABASE_URL;

	private static final String USER;

	private static final String PASSWORD;
	
	static {
		Properties properties = new Properties();
		try {
			properties.load(ConnectionManager.class.getResourceAsStream("/db.properties"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		DRIVER_CLASS = properties.getProperty("driver");
		DATABASE_URL = properties.getProperty("url");
		USER = properties.getProperty("user");
		PASSWORD = properties.getProperty("password");
	}

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
					USER, PASSWORD);

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

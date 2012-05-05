/*
 * cn.jhc.ch06.TitlesBean2.java
 * Y2javaee的ch06的示例，用于演示调用Env.java读取连接信息
 */
package cn.jhc.ch06;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.*;

import cn.jhc.ch03.BookBean;
import cn.jhc.util.SQLCommandBean;


public class TitlesBean3 {
	private Connection connection;

	private String titlesQuery;

	private ResultSet results;

	/**
	 * 返回BookBeans列表
	 * @return
	 */	
	public List getTitles() {
		List titlesList = new ArrayList();

		// 获取书籍列表
		try {
			SQLCommandBean sqlCommandBean = new SQLCommandBean();
			connection = ConnectionManager.getConnection();
			titlesQuery = "SELECT isbn, title, editionNumber, "
					+ "copyright, publisherID, imageFile, price "
					+ "FROM titles ORDER BY title";
			sqlCommandBean.setConnection(connection);
			sqlCommandBean.setSqlValue(titlesQuery);
			Result result = sqlCommandBean.executeQuery();
			if (result == null || result.getRowCount() == 0) {
				// 没有查出Book
				System.out.println("没有书籍!!!");
			} else {
				int rowCount = result.getRowCount();
				// 读取行数据
				for (int i = 0; i < rowCount; i++) {
					Map row = result.getRows()[i];
					BookBean book = new BookBean();

					book.setISBN((String) row.get("isbn"));
					book.setTitle((String) row.get("title"));
					book.setEditionNumber(((Integer) row.get("editionNumber"))
							.intValue());
					book.setCopyright((String) row.get("copyright"));
					book.setPublisherID(((Integer) row.get("publisherID"))
							.intValue());
					book.setImageFile((String) row.get("imageFile"));
					book.setPrice(Double.parseDouble(row.get("price").toString()));
					
					titlesList.add(book);
				}
			}
		}

		// 处理数据库驱动和连接异常
		catch (DBAccessException exception) {
			exception.printStackTrace();
		}

		// 处理数据库异常
		catch (SQLException exception) {
			exception.printStackTrace();
		}

		// 释放资源
		finally {
			try {
				if (results != null) {
					results.close();
					results = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return titlesList;
	}
}

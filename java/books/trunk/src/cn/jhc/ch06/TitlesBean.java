/*
 * cn.jhc.ch06.TitlesBean.java
 * Y2javaee的ch06的示例，用于演示JNDI
 */
package cn.jhc.ch06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.jhc.ch03.BookBean;

public class TitlesBean {
	private Connection connection;

	private PreparedStatement titlesQuery;

	private ResultSet results;

	/** 
	 * 返回BookBeans列表
	 * @return
	 */
	public List getTitles() {
		List titlesList = new ArrayList();

		// 获取书籍列表
		try {
			Context ic = new InitialContext();

			DataSource source = (DataSource) ic
					.lookup("java:comp/env/jdbc/books");

			connection = source.getConnection();
			titlesQuery = connection
					.prepareStatement("SELECT isbn, title, editionNumber, "
							+ "copyright, publisherID, imageFile, price "
							+ "FROM titles ORDER BY title");
			ResultSet results = titlesQuery.executeQuery();

			// 读取行数据
			while (results.next()) {
				BookBean book = new BookBean();

				book.setISBN(results.getString("isbn"));
				book.setTitle(results.getString("title"));
				book.setEditionNumber(results.getInt("editionNumber"));
				book.setCopyright(results.getString("copyright"));
				book.setPublisherID(results.getInt("publisherID"));
				book.setImageFile(results.getString("imageFile"));
				book.setPrice(results.getDouble("price"));

				titlesList.add(book);
			}
		}

		// 处理数据库异常
		catch (SQLException exception) {
			exception.printStackTrace();
		}
		// 处理JNDI查找异常
		catch (NamingException namingException) {
			namingException.printStackTrace();
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

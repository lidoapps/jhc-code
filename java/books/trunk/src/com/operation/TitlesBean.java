package com.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookBean;
import com.util.ConnectionManager;
import com.util.DBAccessException;


public class TitlesBean {
	private Connection connection;

	private PreparedStatement titlesQuery;

	private ResultSet results;

	// 返回BookBeans列表
	public List getTitles() {
		List titlesList = new ArrayList();

		// 获取书籍列表
		try {

			connection = ConnectionManager.getConnection();
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
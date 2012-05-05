/*
 * cn.jhc.ch03.TitlesBean.java
 * Y2javaee的ch03的示例，用于演示购物车
 */
package cn.jhc.ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class TitlesBean {
	private Connection connection;

	private PreparedStatement titlesQuery;

	private ResultSet results;

	// 返回BookBeans列表
	public List getTitles() {
		
		List titlesList = new ArrayList();

		// 获取书籍列表
		try {
			connection = ConnectionManager.getConnction();
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

		// 释放资源
		finally {
			ConnectionManager.closeResultSet(results);
			ConnectionManager.closeStatement(titlesQuery);
			ConnectionManager.closeConnection(connection);
		}
		return titlesList;
	}

}

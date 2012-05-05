/*
 * cn.jhc.ch06.TestSQLCommBean.java
 * Y2javaee的ch06的示例，用于演示调用通用Bean
 */
package cn.jhc.ch06;

import java.sql.*;
import java.util.*;

import javax.servlet.jsp.jstl.sql.*;

import cn.jhc.util.SQLCommandBean;


public class TestSQLCommBean {
	/**
	 * 程序入口
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws DBAccessException,
			SQLException {
		SQLCommandBean sqlCommandBean = new SQLCommandBean();
		sqlCommandBean.setConnection(ConnectionManager.getConnection());
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT isbn, title, editionNumber, ").append(
				"copyright, publisherID, imageFile, price ").append(
				"FROM titles ").append(
				"WHERE price > ? and copyright > ? ORDER BY title");
		sqlCommandBean.setSqlValue(sql.toString());
		List values = new ArrayList();
		values.add(new Double(60.00));
		values.add(new Integer(1997));
		sqlCommandBean.setValues(values);
		Result result = sqlCommandBean.executeQuery();
		if (result == null || result.getRowCount() == 0) {
			// User not found
			System.out.println("没有结果!!!");
		} else {
			System.out.println("有书籍" + result.getRowCount() + "本!!!");
			System.out.println(result.getRows()[0].get("isbn") + " "
					+ result.getRows()[0].get("title"));
		}
	}
}

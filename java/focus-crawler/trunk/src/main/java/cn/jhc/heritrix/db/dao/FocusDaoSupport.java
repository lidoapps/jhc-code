package cn.jhc.heritrix.db.dao;

import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cn.jhc.heritrix.db.DataSourceFactory;
/**
 * 所有DAO的父类，继承自Spring的JdbcDaoSupport，可以充分利用Spring JdbcTemplate的便利功能。
 * @author luyanfei
 *
 */
public class FocusDaoSupport extends JdbcDaoSupport {
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public FocusDaoSupport() {
		this.setDataSource(DataSourceFactory.getDataSource());
	}
	protected static String getCurrentDate() {
		return formatter.format(new java.util.Date());
	}

}

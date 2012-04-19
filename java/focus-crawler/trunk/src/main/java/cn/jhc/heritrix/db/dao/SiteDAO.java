package cn.jhc.heritrix.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import cn.jhc.heritrix.db.DataSourceFactory;
import cn.jhc.heritrix.db.bean.Site;

public class SiteDAO {

	public void insert(final Site site) {
		JdbcTemplate template = new JdbcTemplate(DataSourceFactory.getDataSource());
		template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into site(name,fullname,url,datetime) "
						+ "values(?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, site.getName());
				st.setString(2, site.getFullname());
				st.setString(3, site.getUrl());
				//为防止java.sql.Date截断时、分、秒、毫秒的信息，时间使用setString而不是setDate
				st.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
				return st;
			}
		});
	}
}

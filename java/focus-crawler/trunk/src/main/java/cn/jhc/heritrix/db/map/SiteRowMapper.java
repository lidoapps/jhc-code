package cn.jhc.heritrix.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.jhc.heritrix.db.bean.Site;

public class SiteRowMapper implements RowMapper<Site> {

	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		Site site = new Site();
		site.setId(rs.getInt("id"));
		site.setName(rs.getString("name"));
		site.setFullname(rs.getString("fullname"));
		site.setUrl(rs.getString("url"));
		site.setDatetime(new java.util.Date(rs.getTimestamp("datetime").getTime()));
		return site;
	}

}

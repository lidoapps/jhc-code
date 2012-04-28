package cn.jhc.heritrix.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.jhc.heritrix.bean.Commodity;

public class CommodityRowMapper implements RowMapper<Commodity> {

	public Commodity mapRow(ResultSet rs, int rowNum) throws SQLException {
		Commodity commodity = new Commodity();
		commodity.setId(rs.getLong("id"));
		commodity.setName(rs.getString("name"));
		commodity.setInstanceId(rs.getString("instance_id"));
		commodity.setDateTime(new java.util.Date(rs.getTimestamp("datetime").getTime()));
		return null;
	}

}

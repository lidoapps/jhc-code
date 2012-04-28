package cn.jhc.heritrix.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.jhc.heritrix.bean.CommodityAlias;

public class CommodityAliasRowMapper implements RowMapper<CommodityAlias> {

	public CommodityAlias mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommodityAlias ca = new CommodityAlias();
		ca.setId(rs.getLong("id"));
		ca.setCommodityId(rs.getLong("commodity_id"));
		ca.setAlias(rs.getString("alias"));
		ca.setDateTime(new java.util.Date(rs.getTimestamp("datetime").getTime()));
		return ca;
	}

}

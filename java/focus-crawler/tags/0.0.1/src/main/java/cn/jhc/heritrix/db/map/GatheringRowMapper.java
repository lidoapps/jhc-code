package cn.jhc.heritrix.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import cn.jhc.heritrix.bean.Gathering;

public class GatheringRowMapper implements RowMapper<Gathering> {

	public Gathering mapRow(ResultSet rs, int rowNum) throws SQLException {
		Gathering g = new Gathering();
		g.setId(rs.getLong("id"));
		g.setCommodityId(rs.getLong("commodity_id"));
		g.setContextId(rs.getLong("context_id"));
		g.setMarketPrice(rs.getFloat("market_price"));
		g.setMaxPrice(rs.getFloat("max_price"));
		g.setPromotionPrice(rs.getFloat("promotion_price"));
		g.setPromotionNote(rs.getString("promotion_note"));
		g.setAssessment(rs.getString("assessment"));
		g.setSaledDesc(rs.getString("saled_desc"));
		g.setUrl(rs.getString("url"));
		g.setDateTime(new Date(rs.getTimestamp("datetime").getTime()));
		return g;
	}

}

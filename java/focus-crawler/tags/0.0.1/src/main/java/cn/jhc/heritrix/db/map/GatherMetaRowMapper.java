package cn.jhc.heritrix.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.jhc.heritrix.bean.GatherMeta;

public class GatherMetaRowMapper implements RowMapper<GatherMeta> {

	public GatherMeta mapRow(ResultSet rs, int rowNum) throws SQLException {
		GatherMeta m = new GatherMeta();
		m.setId(rs.getLong("id"));
		m.setGatherId(rs.getLong("gather_id"));
		m.setKey(rs.getString("key"));
		m.setValue(rs.getString("value"));
		return m;
	}

}

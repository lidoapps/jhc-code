package cn.jhc.heritrix.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.jhc.heritrix.db.bean.Context;

public class ContextRowMapper implements RowMapper<Context> {

	public Context mapRow(ResultSet rs, int rowNum) throws SQLException {
		Context ctx = new Context();
		ctx.setId(rs.getLong("id"));
		ctx.setPath(rs.getString("path"));
		ctx.setInstanceID(rs.getLong("instance_id"));
		ctx.setContextLevel(rs.getInt("context_level"));
		ctx.setDatetime(new java.util.Date(rs.getTimestamp("datetime").getTime()));
		return null;
	}

}

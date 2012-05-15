package cn.jhc.heritrix.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cn.jhc.heritrix.bean.Context;

public class ContextDAO extends FocusDaoSupport {

	public long insert(final Context ctx) {
		KeyHolder holder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into context(path,instance_id,context_level,datetime) values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, ctx.getPath());
				ps.setLong(2, ctx.getInstanceID());
				ps.setInt(3, ctx.getContextLevel());
				ps.setString(4, getCurrentDate());
				return ps;
			}
		}, holder);
		
		return holder.getKey().longValue();
	}
	
	public long findContextID(final long instanceId, final int contextLevel) {
		String sql = "select id from context where instance_id=? and context_level=?";
		ResultSetExtractor<Long> rse = new ResultSetExtractor<Long>() {

			public Long extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if(rs.next())
					return rs.getLong(1);
				else
					return 0L;
			}
		};
		return getJdbcTemplate().query(sql, new Object[] {instanceId, contextLevel}, rse);
		
	}
	
	/**
	 * 
	 * @param instanceId
	 * @param contextLevel
	 * @return
	 * 		如果找不到，则返回null，其余情况返回对应的Context对象。
	 */
	public Context findContext(final long instanceId, final int contextLevel) {
		String sql = "select id,path,instance_id,context_level,datetime "
				+ "from context where instance_id=? and context_level=?";
		ResultSetExtractor<Context> rse = new ResultSetExtractor<Context>() {

			public Context extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if(!rs.next())
					return null;
				Context ctx = new Context();
				ctx.setId(rs.getLong(1));
				ctx.setPath(rs.getString(2));
				ctx.setInstanceID(rs.getLong(3));
				ctx.setContextLevel(rs.getInt(4));
				ctx.setDatetime(new java.util.Date(rs.getTimestamp("datetime").getTime()));
				return ctx;
			}
		};
		return getJdbcTemplate().query(sql, new Object[] {instanceId,contextLevel}, rse);
	}

	/**
	 * 根据网站的URL找出该网站默认的ContextID。
	 * @param url
	 * @return
	 */
	public long findSiteContextID(String url) {
		String sql = "select c.id from context as c join site as s on c.instance_id=s.id "
				+ " where c.context_level=10 and s.url=?";
		return getJdbcTemplate().queryForLong(sql, url);
	}
}

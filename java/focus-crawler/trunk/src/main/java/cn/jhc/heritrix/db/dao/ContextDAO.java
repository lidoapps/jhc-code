package cn.jhc.heritrix.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import cn.jhc.heritrix.bean.Context;

public class ContextDAO extends FocusDaoSupport {

	public void insert(final Context ctx) {
		String sql = "insert into context(path,instance_id,context_level,datetime) values(?,?,?,?)";
		getJdbcTemplate().update(sql, 
				ctx.getPath(), ctx.getInstanceID(), ctx.getContextLevel(), getCurrentDate());
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

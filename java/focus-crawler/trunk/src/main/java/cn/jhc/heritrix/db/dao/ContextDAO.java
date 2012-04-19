package cn.jhc.heritrix.db.dao;

import cn.jhc.heritrix.db.bean.Context;

public class ContextDAO extends FocusDaoSupport {

	public void insert(final Context ctx) {
		String sql = "insert into context(path,instance_id,context_level,datetime) values(?,?,?,?)";
		getJdbcTemplate().update(sql, 
				ctx.getPath(), ctx.getInstanceID(), ctx.getContextLevel(), getCurrentDate());
	}
	
	public long getContextID(final long instanceId, final int contextLevel) {
		String sql = "select id from context where instance_id=? and context_level=?";
		return getJdbcTemplate().queryForLong(sql, instanceId, contextLevel);
	}
}

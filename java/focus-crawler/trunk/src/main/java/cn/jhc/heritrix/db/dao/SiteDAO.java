package cn.jhc.heritrix.db.dao;

import cn.jhc.heritrix.db.bean.Site;
import cn.jhc.heritrix.db.map.SiteRowMapper;

public class SiteDAO extends FocusDaoSupport {

	public void insert(final Site site) {
		String sql = "insert into site(name,fullname,url,datetime) values(?,?,?,?)";
		getJdbcTemplate().update(sql, site.getName(), site.getFullname(),
				site.getUrl(), getCurrentDate());
	}

	/**
	 * 根据url查找Site。
	 * @param url 购物网站主页的url。
	 * @return 找到的Site对象。
	 */
	public Site findSite(final String url) {
		String sql = "select id,name,fullname,url,datetime from site where url=?";
		return (Site)getJdbcTemplate().queryForObject(sql, new SiteRowMapper(), url);
	}

}

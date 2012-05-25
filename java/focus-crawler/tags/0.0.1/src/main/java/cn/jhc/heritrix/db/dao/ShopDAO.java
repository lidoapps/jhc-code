package cn.jhc.heritrix.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cn.jhc.heritrix.bean.Shop;

public class ShopDAO extends FocusDaoSupport {
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 
	 * @param url
	 * @return
	 *  	如果找到则返回店铺的id，找不到则返回0。
	 */
	public long findByUrl(String url) {
		if(null == url ) return 0L;
		String sql = "select id from shop where url=?";
		ResultSetExtractor<Long> rse = new ResultSetExtractor<Long>() {

			public Long extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if(!rs.next())
					return 0L;
				return rs.getLong(1);
			}
		};
		return getJdbcTemplate().query(sql, rse, url);
	}

	/**
	 * 插入店铺信息
	 * @param shop
	 * @return
	 * 		刚插入数据库中的shop记录的id。
	 */
	public long insert(final Shop shop) {
		KeyHolder holder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into shop(name,site_id,url,assessment,amount,createdate,datetime) "
						+ "values(?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, shop.getName());
				ps.setInt(2, shop.getSiteId());
				ps.setString(3, shop.getUrl());
				ps.setString(4, shop.getAssessment());
				ps.setInt(5, shop.getAmount());
				ps.setString(6, format.format(shop.getCreateDate()));
				ps.setString(7, getCurrentDate());
				return ps;
			}
		}, holder);
		return holder.getKey().longValue();
	}

	/**
	 * 
	 * @param shopId
	 * @return
	 * 		如果对应shop记录存在，则返回Shop对象，否则返回null.
	 */
	public Shop findShop(long shopId) {
		String sql = "select id,name,site_id,url,assessment,amount,createdate,datetime "
				+ "from shop where id=?";
		ResultSetExtractor<Shop> rse = new ResultSetExtractor<Shop>() {

			public Shop extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if(!rs.next())
					return null;
				Shop s = new Shop();
				s.setId(rs.getLong(1));
				s.setName(rs.getString(2));
				s.setSiteId(rs.getInt(3));
				s.setUrl(rs.getString(4));
				s.setAssessment(rs.getString(5));
				s.setAmount(rs.getInt(6));
				s.setCreateDate(rs.getDate(7));
				s.setDatetime(new java.util.Date(rs.getTimestamp(8).getTime()));
				return s;
			}
		};
		return getJdbcTemplate().query(sql, rse, shopId);
	}

}

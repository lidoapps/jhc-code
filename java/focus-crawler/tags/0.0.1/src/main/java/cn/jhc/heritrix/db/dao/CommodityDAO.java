package cn.jhc.heritrix.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cn.jhc.heritrix.bean.Commodity;
import cn.jhc.heritrix.db.map.CommodityRowMapper;

public class CommodityDAO extends FocusDaoSupport {

	/**
	 * 通过商品的名字来查找商品。
	 * @param name
	 * 		商品的名字。
	 * @return
	 * 		找到的商品的id，若不能找到，则返回0。
	 */
	public List<Commodity> findByName(String name) {
		if(name == null)
			return null;
		String sql = "select id,name,instance_id,datetime from commodity where name=?";
		return getJdbcTemplate().query(sql, new CommodityRowMapper(), name);
	}
	/**
	 * 通过商品的instance_id来查找商品。
	 * @param instanceId
	 * @return
	 * 		找到的商品的id，若不能找到，则返回null。
	 */
	public Commodity findByInstanceId(String instanceId) {
		if(instanceId == null)
			return null;
		String sql = "select id,name,instance_id,datetime from commodity where instance_id=?";
		ResultSetExtractor<Commodity> rse = new ResultSetExtractor<Commodity>() {

			public Commodity extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if(!rs.next())
					return null;
				Commodity commodity = new Commodity();
				commodity.setId(rs.getLong(1));
				commodity.setName(rs.getString(2));
				commodity.setDateTime(new java.util.Date(rs.getTimestamp(3).getTime()));
				return commodity;
			}
		};
		return getJdbcTemplate().query(sql, new Object[] { instanceId }, rse);
	}
	/**
	 * 根据商品的主键查找商品。
	 * @param id
	 * 		商品的主键。
	 * @return
	 * 		Commodity对象。
	 */
	public Commodity findById(long id) {
		String sql = "select id,name,instance_id,datetime from commodity where id=?";
		return getJdbcTemplate().queryForObject(sql, new CommodityRowMapper(), id);
	}
	/**
	 * 插入Commodity记录。
	 * @param commodity
	 * 		需要保存到数据库的Commodity对象。
	 * @return
	 * 		返回刚插入的Commodity记录的id。
	 */
	public long insert(final Commodity commodity) {
		KeyHolder holder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into commodity(name,instance_id,datetime) values(?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, commodity.getName());
				ps.setString(2, commodity.getInstanceId());
				ps.setString(3, getCurrentDate());
				return ps;
			}
		}, holder);
		return holder.getKey().longValue();
	}
	
	/**
	 * 当新加商品的instance_id在数据库中已经存在时，需要添加CommodityAlias记录。
	 * @param commodityId
	 * @param alias
	 */
	public void insertAlias(long commodityId, String alias) {
		String sql = "insert into commodity_alias(alias,commodity_id,datetime) values(?,?,?)";
		getJdbcTemplate().update(sql, alias,commodityId,getCurrentDate());
	}
}

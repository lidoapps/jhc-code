package cn.jhc.heritrix.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cn.jhc.heritrix.bean.Commodity;

public class CommodityDAO extends FocusDaoSupport {

	/**
	 * 通过商品的名字来查找商品。
	 * @param name
	 * 		商品的名字。
	 * @return
	 * 		找到的商品的id，若不能找到，则返回0。
	 */
	public List<Commodity> findByName(String name) {
		
		return null;
	}
	/**
	 * 通过商品的instance_id来查找商品。
	 * @param instanceId
	 * @return
	 * 		找到的商品的id，若不能找到，则返回null。
	 */
	public Commodity findByInstanceId(String instanceId) {
		
		return null;
	}
	/**
	 * 根据商品的主键查找商品。
	 * @param id
	 * 		商品的主键。
	 * @return
	 * 		Commodity对象。
	 */
	public Commodity findById(long id) {
		return null;
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
}

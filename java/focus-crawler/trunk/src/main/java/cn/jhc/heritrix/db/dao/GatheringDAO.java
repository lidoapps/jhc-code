package cn.jhc.heritrix.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cn.jhc.heritrix.bean.Gathering;

public class GatheringDAO extends FocusDaoSupport {

	/**
	 * 插入Gathering记录
	 * @param gathering
	 * @return
	 * 		刚插入的Gathering记录的id。
	 */
	public long insert(final Gathering gathering) {
		KeyHolder holder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into gathering(commodity_id,context_id,market_price,max_price,"
						+ "promotion_price,promotion_note,saled_desc,url,datetime) "
						+ "values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement stat = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				stat.setLong(1, gathering.getCommodityId());
				stat.setLong(2, gathering.getContextId());
				stat.setFloat(3, gathering.getMarketPrice());
				stat.setFloat(4, gathering.getMaxPrice());
				stat.setFloat(5, gathering.getPromotionPrice());
				stat.setString(6, gathering.getPromotionNote());
				stat.setString(7, gathering.getSaledDesc());
				stat.setString(8, gathering.getUrl());
				stat.setString(9, getCurrentDate());
				return stat;
			}
		}, holder);
		return holder.getKey().longValue();
	}

	/**
	 * 根据Gathering的id把属性值写入数据库
	 * @param id
	 * @param attributes
	 */
	public void insertMeta(long id, Map<String, String> attributes) {
		// TODO Auto-generated method stub
		
	}

}

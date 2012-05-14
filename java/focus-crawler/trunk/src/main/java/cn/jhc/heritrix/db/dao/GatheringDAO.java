package cn.jhc.heritrix.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
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
						+ "promotion_price,promotion_note,saled_desc,assessment,url,datetime) "
						+ "values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement stat = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				stat.setLong(1, gathering.getCommodityId());
				stat.setLong(2, gathering.getContextId());
				stat.setFloat(3, gathering.getMarketPrice());
				stat.setFloat(4, gathering.getMaxPrice());
				stat.setFloat(5, gathering.getPromotionPrice());
				stat.setString(6, gathering.getPromotionNote());
				stat.setString(7, gathering.getSaledDesc());
				stat.setString(8, gathering.getAssessment());
				stat.setString(9, gathering.getUrl());
				stat.setString(10, getCurrentDate());
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
	public void insertMeta(final long id, Map<String, String> attributes) {
		String sql = "insert into gather_meta(gather_id,meta_key,meta_value) values(?,?,?)";
		final Object[] entries = attributes.entrySet().toArray();
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Map.Entry<String, String> entry = (Map.Entry<String, String>)entries[i];
				ps.setLong(1, id);
				ps.setString(2, entry.getKey());
				ps.setString(3, entry.getValue());
			}
			
			public int getBatchSize() {
				return entries.length;
			}
		});
	}

}

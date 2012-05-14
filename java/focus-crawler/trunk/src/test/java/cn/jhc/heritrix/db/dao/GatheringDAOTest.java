package cn.jhc.heritrix.db.dao;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.dbunit.Assertion;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import cn.jhc.heritrix.bean.Gathering;
import cn.jhc.heritrix.db.FocusDBTestCase;

public class GatheringDAOTest extends FocusDBTestCase {
	
	private GatheringDAO dao;
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		dao = DAOFactory.getGatheringDAO();
	}

	@Test
	public void testInsert() throws DataSetException, SQLException, Exception {
		Gathering g = new Gathering();
		g.setContextId(2);
		g.setCommodityId(2);
		g.setMarketPrice(50.0f);
		g.setMaxPrice(60.0f);
		g.setPromotionPrice(40.0f);
		g.setPromotionNote("promotion");
		g.setAssessment("good");
		g.setSaledDesc("500件");
		g.setUrl("http://none.item/");
		long id = dao.insert(g);
//		assertEquals(2, id);
		ITable actualTable = getConnection().createQueryTable("Gathering", 
				"select commodity_id,context_id,market_price,max_price,promotion_price,"
				+ "promotion_note,assessment,saled_desc,url from gathering");
		ITable expectedTable = new FlatXmlDataFileLoader().load("/dataset/gathering_dataset.xml")
				.getTable("gathering_select");
		Assertion.assertEquals(expectedTable, actualTable);
	}

	@Test
	public void testInsertMeta() throws DataSetException, SQLException, Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		dao.insertMeta(1L, map);
		ITable actualTable = getConnection().createQueryTable("gather_meta", 
				"select gather_id,meta_key,meta_value from gather_meta order by 1,2");
		ITable expectedTable = new FlatXmlDataFileLoader().load("/dataset/gathermeta_dataset.xml")
				.getTable("gather_meta");
		Assertion.assertEquals(expectedTable, actualTable);
	}
}

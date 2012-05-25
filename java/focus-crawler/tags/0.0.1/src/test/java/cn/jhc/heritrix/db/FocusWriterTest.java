package cn.jhc.heritrix.db;

import java.math.BigInteger;
import java.sql.SQLException;
import java.text.DateFormat;

import org.dbunit.Assertion;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import cn.jhc.heritrix.bean.Shop;
import cn.jhc.heritrix.db.dao.Constants;

public class FocusWriterTest extends FocusDBTestCase{

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testShopContext() throws DataSetException, SQLException, Exception {
		Shop shop = new Shop("阿里妈妈", "http://alimama.com/", 3, "不好",
				300, DateFormat.getDateInstance().parse("2012-01-01"));
		long shopId = FocusWriter.checkShop(shop);
		assertTrue( shopId>0L );
		ITable actualTable = getConnection().createQueryTable("shop_select", 
				"select name,site_id,url,assessment,amount,createdate from shop order by site_id");
		ITable expectedTable = new FlatXmlDataFileLoader().load("/dataset/shop_dataset.xml")
				.getTable("shop_select");
		Assertion.assertEquals(expectedTable, actualTable);
		long contextId = FocusWriter.getShopContextId(shopId);
		assertTrue( contextId>0L );
		ITable ctable = getConnection().createQueryTable("ctable", 
				"select path,instance_id,context_level from context where id=" + contextId);
		String path = (String) ctable.getValue(0, "path");
		assertEquals("3/"+contextId, path);
		long instanceId = ((BigInteger) ctable.getValue(0, "instance_id")).longValue();
		assertEquals(shopId, instanceId);
		int level = (Integer) ctable.getValue(0, "context_level");
		assertEquals(Constants.SHOP_LEVEL, level);
	}

}

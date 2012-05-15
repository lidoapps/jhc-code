package cn.jhc.heritrix.db.dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.dbunit.Assertion;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import cn.jhc.heritrix.bean.Shop;
import cn.jhc.heritrix.db.FocusDBTestCase;

public class ShopDAOTest extends FocusDBTestCase {
	
	private ShopDAO dao;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		dao = DAOFactory.getShopDAO();
	}

	@Test
	public void testFindByUrl() {
		long id1 = dao.findByUrl(null);
		assertEquals(0L, id1);
		long id2 = dao.findByUrl("http://none/");
		assertEquals(0L, id2);
		long id3 = dao.findByUrl("http://alibaba.com/");
		assertEquals(1, id3);
	}

	@Test
	public void testInsert() throws DataSetException, SQLException, Exception {
		Shop shop = new Shop("阿里妈妈", "http://alimama.com/", 3, "不好",
				300, DateFormat.getDateInstance().parse("2012-01-01"));
		dao.insert(shop);
		ITable actualTable = getConnection().createQueryTable("shop_select", 
				"select name,site_id,url,assessment,amount,createdate from shop order by site_id");
		ITable expectedTable = new FlatXmlDataFileLoader().load("/dataset/shop_dataset.xml")
				.getTable("shop_select");
		Assertion.assertEquals(expectedTable, actualTable);
	}

	@Test
	public void testFindShop() {
		fail("Not yet implemented");
	}

}

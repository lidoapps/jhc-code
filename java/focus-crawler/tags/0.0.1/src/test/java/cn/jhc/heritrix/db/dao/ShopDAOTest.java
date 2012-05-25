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
	public void testFindShop() {
		Shop shop1 = dao.findShop(10);
		assertNull(shop1);
		Shop shop2 = dao.findShop(1);
		assertEquals("阿里巴巴", shop2.getName());
		assertEquals(2, shop2.getSiteId());
		assertEquals("http://alibaba.com/", shop2.getUrl());
		assertEquals("很好", shop2.getAssessment());
		assertEquals(200, shop2.getAmount());
		assertEquals("2012-01-01", new SimpleDateFormat("yyyy-MM-dd").format(shop2.getCreateDate()));
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

}

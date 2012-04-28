package cn.jhc.heritrix.db.dao;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;

import cn.jhc.heritrix.bean.Commodity;
import cn.jhc.heritrix.db.FocusDBTestCase;

public class CommodityDAOTest extends FocusDBTestCase {

	@Test
	public void testFindByName() {
		String name = "Apple/苹果 iPhone 4S 【16G 32G 64 G 正品 大陆行货 带票】";
		List<Commodity> list = DAOFactory.getCommodityDAO().findByName(name);
		assertEquals(1, list.size());
		assertNull(list.get(0).getInstanceId());
		assertEquals("Apple/苹果 iPhone 4S 【16G 32G 64 G 正品 大陆行货 带票】", list.get(0).getName());
	}

	@Test
	public void testFindByInstanceId() {
		Commodity c = DAOFactory.getCommodityDAO().findByInstanceId(null);
		assertNull(c);
	}

	@Test
	public void testFindById() {
		Commodity c = DAOFactory.getCommodityDAO().findById(1);
		assertEquals("Apple/苹果 iPhone 4S 【16G 32G 64 G 正品 大陆行货 带票】", c.getName());
		assertNull(c.getInstanceId());
		assertEquals(1, c.getId());
	}

	@Test
	public void testInsert() throws DataSetException, SQLException, Exception {
		Commodity commodity = new Commodity();
		commodity.setName("正版：Perl语言入门（第五版）（原书名：Learning Perl，5/e)");
		commodity.setInstanceId("9787564117634");
		long r = DAOFactory.getCommodityDAO().insert(commodity);
		ITable actualTable = getConnection().createQueryTable("commodity",
				"select name,instance_id from commodity");
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		//instance_id可能为null，需要仔细处理
		builder.setColumnSensing(true);
		DataFileLoader loader = new FlatXmlDataFileLoader(builder);
		ITable expectedTable = loader.load("/dataset/commodity_dataset.xml").getTable("commodity_select");
		Assertion.assertEquals(expectedTable, actualTable);
	}

	@Test
	public void testInsertAlias() throws DataSetException, SQLException, Exception {
		DAOFactory.getCommodityDAO().insertAlias(1, "iPhone 4S");
		ITable actualTable = getConnection().createQueryTable("alias",
				"select alias,commodity_id from commodity_alias");
		DataFileLoader loader = new FlatXmlDataFileLoader();
		ITable expectedTable = loader.load("/dataset/alias_dataset.xml").getTable("alias_select");
		Assertion.assertEquals(expectedTable, actualTable);
	}
}

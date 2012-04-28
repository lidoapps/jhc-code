package cn.jhc.heritrix.db.dao;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import cn.jhc.heritrix.bean.Commodity;
import cn.jhc.heritrix.db.FocusDBTestCase;

public class CommodityDAOTest extends FocusDBTestCase {

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByInstanceId() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() throws DataSetException, SQLException, Exception {
		Commodity commodity = new Commodity();
		commodity.setName("正版：Perl语言入门（第五版）（原书名：Learning Perl，5/e)");
		commodity.setInstanceId("9787564117634");
		long r = DAOFactory.getCommodityDAO().insert(commodity);
		ITable actualTable = getConnection().createQueryTable("commodity",
				"select name,instance_id from commodity");
		DataFileLoader loader = new FlatXmlDataFileLoader();
		ITable expectedTable = loader.load("/dataset/commodity_dataset.xml").getTable("commodity_select");
		Assertion.assertEquals(expectedTable, actualTable);
	}

}

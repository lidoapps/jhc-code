package cn.jhc.heritrix.db.dao;

import org.dbunit.Assertion;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;

import cn.jhc.heritrix.db.FocusDBTestCase;
import cn.jhc.heritrix.db.bean.Context;

public class ContextDAOTest extends FocusDBTestCase {

	@Test
	public void testInsert() throws Exception{
		Context ctx = new Context("5",5,10);
		ContextDAO dao = DAOFactory.getContextDAO();
		dao.insert(ctx);
		ITable actualTable = getConnection().createQueryTable("context", 
				"select path,instance_id,context_level from context");
		DataFileLoader loader = new FlatXmlDataFileLoader();
		ITable expectedTable = loader.load("/dataset/context_dataset.xml").getTable("context_select");
		Assertion.assertEquals(expectedTable, actualTable);
	}
	
	@Test
	public void testGetContextID() throws Exception {
		ContextDAO dao = DAOFactory.getContextDAO();
		long id1 = dao.getContextID(4, 10);
		assertEquals(4L, id1);
		long id2 = dao.getContextID(3, 10);
		assertEquals(3L, id2);
	}
}

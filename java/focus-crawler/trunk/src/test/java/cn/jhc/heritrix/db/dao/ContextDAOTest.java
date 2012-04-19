package cn.jhc.heritrix.db.dao;

import org.junit.Test;

import cn.jhc.heritrix.db.FocusDBTestCase;

public class ContextDAOTest extends FocusDBTestCase {

	@Test
	public void testGetContextID() throws Exception {
		ContextDAO dao = DAOFactory.getContextDAO();
		long id1 = dao.getContextID(4, 10);
		assertEquals(4L, id1);
		long id2 = dao.getContextID(3, 10);
		assertEquals(3L, id2);
	}
}

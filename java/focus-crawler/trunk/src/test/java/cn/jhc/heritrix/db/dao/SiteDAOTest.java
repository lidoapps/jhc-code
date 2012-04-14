package cn.jhc.heritrix.db.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.jhc.heritrix.db.bean.Site;

public class SiteDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdate() {
		Site site = new Site("天猫网","天猫网","http://www.tmall.com/");
		try {
			SiteDAO dao = DAOFactory.getSiteDAO();
			dao.insert(site);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

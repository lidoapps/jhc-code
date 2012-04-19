package cn.jhc.heritrix.db.dao;

import java.text.SimpleDateFormat;

import org.dbunit.Assertion;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.jhc.heritrix.db.FocusDBTestCase;
import cn.jhc.heritrix.db.bean.Site;

public class SiteDAOTest extends FocusDBTestCase {

	@Test
	public void testUpdate() throws Exception {
		Site site = new Site("互动出版网", "互动出版网", "http://www.china-pub.com/");

		SiteDAO dao = DAOFactory.getSiteDAO();
		dao.insert(site);
		
		ITable actualTable = getConnection()
				.createQueryTable("site", "select name,fullname,url from site");
		
		DataFileLoader loader = new FlatXmlDataFileLoader();
		ITable expectedTable = loader.load("/site_dataset.xml").getTable("site_select");
		Assertion.assertEquals(expectedTable, actualTable);
		
	}
	
	@Test
	public void testFindSite() throws Exception{
		Site site = DAOFactory.getSiteDAO().findSite("http://www.tmall.com/");
		assertEquals("天猫网", site.getName());
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(site.getDatetime());
//		System.out.println(date.substring(date.indexOf(" ")+1));
		assertNotSame("00:00:00", date.substring(date.indexOf(" ")+1));
	}

}

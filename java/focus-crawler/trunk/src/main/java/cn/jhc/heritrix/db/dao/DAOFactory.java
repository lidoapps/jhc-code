package cn.jhc.heritrix.db.dao;
/**
 * Factory Method Pattern
 * @author luyanfei
 *
 */
public class DAOFactory {

	public static SiteDAO getSiteDAO() {
		return (SiteDAO) createDAO(SiteDAO.class);
	}

	public static ContextDAO getContextDAO() {
		return (ContextDAO) createDAO(ContextDAO.class);
	}
	
	private static Object createDAO(Class classObj) {
		Object obj;
		try {
			obj = classObj.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return obj;
	}
}

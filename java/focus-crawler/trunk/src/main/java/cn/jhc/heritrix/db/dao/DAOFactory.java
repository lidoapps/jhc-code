package cn.jhc.heritrix.db.dao;
/**
 * Factory Method Pattern
 * @author luyanfei
 *
 */
public class DAOFactory {

	public static SiteDAO getSiteDAO() throws Exception {
		return (SiteDAO) createDAO(SiteDAO.class);
	}

	public static ContextDAO getContextDAO() throws Exception {
		return (ContextDAO) createDAO(ContextDAO.class);
	}
	
	private static Object createDAO(Class classObj) throws DAOException  {
		Object obj;
		try {
			obj = classObj.newInstance();
		} catch (InstantiationException e) {
			throw new DAOException(e);
		} catch (IllegalAccessException e) {
			throw new DAOException(e);
		}
		return obj;
	}
}

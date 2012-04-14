package cn.jhc.heritrix.db.dao;

public class DAOFactory {

	public static SiteDAO getSiteDAO() throws Exception {
		return (SiteDAO) createDAO(SiteDAO.class);
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

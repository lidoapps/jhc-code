package cn.jhc.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.jhc.util.Constants;

public class DbFactory {
public static Connection getConnection(){		
		
		Connection conn = null;		
		try {
			Context ctx = new InitialContext();
			  if (ctx == null){ throw new Exception("No Context"); }
			  // public static String  DB_JNDI  =  "java:comp/env/jdbc/lab";
			  DataSource ds = (DataSource)ctx.lookup(Constants.DB_JNDI);
			  if (ds != null) {
			    conn = ds.getConnection();			       
			  }
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return conn;	
		
	}

}

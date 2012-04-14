package cn.jhc.heritrix.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class DataSourceFactory {

	private static MysqlConnectionPoolDataSource ds = null;
	
	static {
		Properties properties = new Properties();
	
			InputStream input = DataSourceFactory.class.getResourceAsStream("/datasource.conf");
			
			try {
				properties.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}

		ds = new MysqlConnectionPoolDataSource();
		ds.setServerName(properties.getProperty("host"));
		ds.setDatabaseName(properties.getProperty("db"));
		ds.setUser(properties.getProperty("user"));
		ds.setPassword(properties.getProperty("password"));
				
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
}

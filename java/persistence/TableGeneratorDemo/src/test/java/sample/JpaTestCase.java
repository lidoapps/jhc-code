package sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class JpaTestCase {

	EntityManagerFactory factory;
	protected EntityManager em;
	protected static Connection conn;
	
	@Before public void setUp() {
		Properties properties = loadProperties();
		factory = Persistence.createEntityManagerFactory("gen_demo", properties);
		em = factory.createEntityManager();
	}
	
	@After public void shutDown() {
		em.close();
		factory.close();
	}

	/**
	 * 子类可以覆盖此方法，添加更多配置
	 * @return
	 */
	protected Properties loadProperties() {
		Properties p = new Properties();
		try {
			InputStream input = JpaTestCase.class.getClassLoader().getResourceAsStream("persistence.properties");
			p.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	
	@BeforeClass public static void setUpBeforeClass() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=testuser&password=testpass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass public static void tearDownAfterClass() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void printTable(String tableName) {
		
		System.out.println("###########################################################################");
		System.out.println("Print table: " + tableName);

		Statement stat = null;
		ResultSet rs = null;
		
		try {
			stat = conn.createStatement();
			String sql = "select * from " + tableName;
			rs = stat.executeQuery(sql);
			ResultSetMetaData meta = rs.getMetaData();
			
			//打印表头
			int cols = meta.getColumnCount();
			int num = cols * 30 + cols + 1;
			for(int k=0; k<num; k++) System.out.print('-');
			System.out.println();
			System.out.print('|');
			for(int i=1; i<=cols; i++) {
				System.out.printf("%-30s|", meta.getColumnName(i));
			}
			System.out.println();
			for(int k=0; k<num; k++) System.out.print('-');
			System.out.println();
			
			//打印表
			while(rs.next()) {
				System.out.print('|');
				for(int i=1; i<=cols; i++)
					System.out.printf("%-30s|", rs.getString(i));
				System.out.println();
			}
			for(int k=0; k<num; k++)  System.out.print('-');
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}

package cn.jhc.heritrix.db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class MySQLDataSourceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Connection con = null;
		try {
			con = MySQLDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull("The connection is null.",con);
	}

}

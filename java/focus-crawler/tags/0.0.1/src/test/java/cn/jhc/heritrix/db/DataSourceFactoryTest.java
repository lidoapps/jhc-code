package cn.jhc.heritrix.db;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;

public class DataSourceFactoryTest {

	@Test
	public void testGetDataSource() {
		DataSource ds = DataSourceFactory.getDataSource();
		assertNotNull("The connection is null.",ds);
	}

}

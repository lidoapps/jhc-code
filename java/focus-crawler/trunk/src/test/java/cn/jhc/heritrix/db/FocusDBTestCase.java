package cn.jhc.heritrix.db;

import java.io.File;
import java.io.FileInputStream;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
/**
 * 所有数据库测试类的父类，实现了DBUnit的配置。
 * @author luyanfei
 *
 */
public class FocusDBTestCase extends DBTestCase {

	public FocusDBTestCase() {
		super();
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/focus");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "huser");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "hpass");
	}
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	@Override
	protected IDataSet getDataSet() throws Exception {
		
		return new FlatXmlDataSetBuilder().build(FocusDBTestCase.class.getResourceAsStream("/dataset/initial_dataset.xml"));
	}

	@Override
	protected void setUpDatabaseConfig(DatabaseConfig config) {
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
	}
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.CLEAN_INSERT;
	}

	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.NONE;
	}
}

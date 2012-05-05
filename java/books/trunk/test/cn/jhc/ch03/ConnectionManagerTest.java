package cn.jhc.ch03;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import cn.jhc.ch03.ConnectionManager;
import static org.junit.Assert.*;

public class ConnectionManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetConnction() {
		Connection con = ConnectionManager.getConnction();
		assertNotNull(con);
	}

}

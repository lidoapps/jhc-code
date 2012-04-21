package cn.jhc.heritrix.writer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaobaoJdbcWriterProcessorTest {
	
	private TaobaoJdbcWriterProcessor processor;
	
	@Before
	public void setUp() {
		processor = new TaobaoJdbcWriterProcessor("test processor");
	}

	@Test
	public void testValidateUri() {
		String uri1 = "http://item.taobao.com/item.htm?id=9505588655";
		assertTrue(processor.validateUri(uri1));
		String uri2 = "http://www.taobao.com/";
		assertFalse(processor.validateUri(uri2));
	}

	@Test
	public void testGetDefaultContextId() {
		assertEquals(3, processor.getDefaultContextId());
	}

	@Test
	public void testExtract() {
		
	}

}

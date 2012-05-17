package cn.jhc.heritrix.writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TaobaoJdbcWriterProcessorTest {
	
	private TaobaoJdbcWriterProcessor processor;

	
	@Before
	public void setUp() throws IOException {
		processor = new TaobaoJdbcWriterProcessor("test processor");
	}

	@Test
	public void testValidateUri() {
		String uri1 = "http://item.taobao.com/item.htm?id=9505588655";
		assertTrue(processor.validateUri(uri1));
		String uri2 = "http://www.taobao.com/";
		assertFalse(processor.validateUri(uri2));
		String uri3 = "http://item.taobao.com/item.htm?spm=929.215620.241354.9&id=14673342227";
		assertTrue(processor.validateUri(uri3));
		String uri4 = "http://item.taobao.com/item.htm?id=13255652698&|"
				+ "http://detail.tmall.com/item.htm?spm=11046BE7.1-9ufzb.3-5lg9XZ&id=13447892008&|||"
				+ "http://detail.tmall.com/item.htm?id=10952854370&|"
				+ "http://item.taobao.com/item.htm?id=14114401822|" 
				+ "http://item.taobao.com/item.htm?id=13240860801|"
				+ "http://item.taobao.com/item.htm?id=14753160206&|"
				+"http://item.taobao.com/item.htm?id=16152252898";
		assertTrue(processor.validateUri(uri4));
	}

}

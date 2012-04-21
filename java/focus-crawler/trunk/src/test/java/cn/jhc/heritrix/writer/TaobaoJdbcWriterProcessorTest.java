package cn.jhc.heritrix.writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

public class TaobaoJdbcWriterProcessorTest {
	
	private TaobaoJdbcWriterProcessor processor;
	//iPhone 4S taobao网页
	private Document doc1 = null;
	
	@Before
	public void setUp() throws IOException {
		processor = new TaobaoJdbcWriterProcessor("test processor");
		InputStream stream1 = TaobaoJdbcWriterProcessorTest.class.getResourceAsStream("/html/taobaoitem1.htm");
		doc1 = Jsoup.parse(stream1, null, "http://item.taobao.com/");

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
	
	@Test
	public void testGetCommodityName() {
		String name = processor.getCommodityName(doc1);
		assertEquals("Apple/苹果 iPhone 4S(有锁) iphon4S 32G 手机 全新原封大陆行货", name);
	}

}

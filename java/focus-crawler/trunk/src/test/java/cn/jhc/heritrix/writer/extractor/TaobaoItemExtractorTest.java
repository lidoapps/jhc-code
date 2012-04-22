package cn.jhc.heritrix.writer.extractor;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import cn.jhc.heritrix.writer.TaobaoJdbcWriterProcessorTest;

public class TaobaoItemExtractorTest {

	
	private TaobaoItemExtractor extractor1 = null;
	
	@Before
	public void setUp() throws Exception {
		//iPhone 4S taobao网页
		InputStream stream1 = TaobaoJdbcWriterProcessorTest.class.getResourceAsStream("/html/taobaoitem1.htm");
		Document doc1 = Jsoup.parse(stream1, null, "http://item.taobao.com/");
		extractor1 = new TaobaoItemExtractor(doc1);
	}

	@Test
	public void testGetCommodityName() {
		String name = extractor1.getCommodityName();
		assertEquals("Apple/苹果 iPhone 4S(有锁) iphon4S 32G 手机 全新原封大陆行货", name);
	}

}

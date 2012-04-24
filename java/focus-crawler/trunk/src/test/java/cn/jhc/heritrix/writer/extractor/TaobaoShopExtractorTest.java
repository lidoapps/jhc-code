package cn.jhc.heritrix.writer.extractor;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import cn.jhc.heritrix.writer.TaobaoJdbcWriterProcessorTest;

public class TaobaoShopExtractorTest {

	private TaobaoShopExtractor extractor1 = null;
	@Before
	public void setUp() throws Exception {
		//iPhone 4S taobao网页
		InputStream stream1 = TaobaoJdbcWriterProcessorTest.class.getResourceAsStream("/html/taobaoitem1.htm");
		Document doc1 = Jsoup.parse(stream1, null, "http://item.taobao.com/");
		extractor1 = new TaobaoShopExtractor(doc1);
	}

	@Test
	public void testExtractName() {
		assertEquals("中国专业数码", extractor1.extractName());
	}

	@Test
	public void testExtractUrl() {
		assertEquals("http://shop63116330.taobao.com/", extractor1.extractUrl());
	}

	@Test
	public void testExtractAssessment() {
		assertEquals("s_blue_2.gif", extractor1.extractAssessment());
	}

	@Test
	public void testExtractAmount() {
		assertEquals(234, extractor1.extractAmount());
	}

	@Test
	public void testExtractCeateDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals("2010-10-17", df.format(extractor1.extractCreateDate()));
	}

}

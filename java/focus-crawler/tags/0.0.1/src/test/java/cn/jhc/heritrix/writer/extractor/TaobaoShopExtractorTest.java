package cn.jhc.heritrix.writer.extractor;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Properties;

import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

public class TaobaoShopExtractorTest extends TaobaoTest{

	public TaobaoShopExtractorTest(Document doc, Properties props) {
		super(doc, props);
	}

	private TaobaoShopExtractor extractor1 = null;
	
	@Before
	public void setUp() throws Exception {
		extractor1 = new TaobaoShopExtractor(doc);
	}

	@Test
	public void testExtractName() {
		assertEquals(props.getProperty("shop.name"), extractor1.extractName());
	}

	@Test
	public void testExtractUrl() {
		assertEquals(props.getProperty("shop.url"), extractor1.extractUrl());
	}

	@Test
	public void testExtractAssessment() {
		assertEquals(props.getProperty("shop.assessment"), extractor1.extractAssessment());
	}

	@Test
	public void testExtractAmount() {
		int amount = Integer.valueOf(props.getProperty("shop.amount"));
		assertEquals(amount, extractor1.extractAmount());
	}

	@Test
	public void testExtractCeateDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(props.getProperty("shop.createdate"), df.format(extractor1.extractCreateDate()));
	}

}

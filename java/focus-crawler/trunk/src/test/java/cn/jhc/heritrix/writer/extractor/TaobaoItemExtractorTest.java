package cn.jhc.heritrix.writer.extractor;

import static org.junit.Assert.assertEquals;
import org.hamcrest.collection.IsMapContaining;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

public class TaobaoItemExtractorTest extends TaobaoTest {

	
	public TaobaoItemExtractorTest(Document doc, Properties properties) {
		super(doc, properties);
	}

	private TaobaoItemExtractor extractor1 = null;
	
	@Before
	public void setUp() throws Exception {
		extractor1 = new TaobaoItemExtractor(doc);
	}

	@Test
	public void testExtractCommodityName() {
		String name = extractor1.extractCommodityName();
		assertEquals(props.getProperty("item.name"), name);
	}

	@Test
	public void testExtractMarketPrice() {
		float actual = extractor1.extractMarketPrice();
		float expected = Float.valueOf(props.getProperty("item.marketprice"));
		assertEquals(expected, actual, Double.MIN_VALUE);
	}
	@Test
	public void testExtractMaxPrice() {
		float actual = extractor1.extractMaxPrice();
		float expected = Float.valueOf(props.getProperty("item.maxprice"));
		assertEquals(expected, actual, Double.MIN_VALUE);
	}
	@Test
	public void testExtractAttributes() {
		Map<String,String> map = extractor1.extractAttributes();
		Set<Map.Entry<String, String>> entries = map.entrySet();
		for(Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
			
	}
}

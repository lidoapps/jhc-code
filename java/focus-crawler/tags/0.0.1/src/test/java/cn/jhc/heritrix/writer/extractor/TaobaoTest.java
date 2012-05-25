package cn.jhc.heritrix.writer.extractor;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class TaobaoTest {
	
	protected Document doc;
	protected Properties props;

	public TaobaoTest(Document doc, Properties properties) {
		this.doc = doc;
		this.props = properties;
	}

	@Parameters
	public static List<Object[]> provideDocuments() throws IOException{
		List<Object[]> list = new ArrayList<Object[]>();
		//iPhone 4S taobao网页
		InputStream stream1 = TaobaoTest.class.getResourceAsStream("/html/taobaoitem1.htm");
		Document doc1 = Jsoup.parse(stream1, null, "http://item.taobao.com/");
		
		InputStream stream2 = TaobaoTest.class.getResourceAsStream("/html/taobaoitem1.properties");
		Properties prop1 = new Properties();
		prop1.load(stream2);
		list.add(new Object[] {doc1,prop1});
		return list;
	}
}

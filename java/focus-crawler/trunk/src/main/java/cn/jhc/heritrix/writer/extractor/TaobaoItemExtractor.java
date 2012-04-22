package cn.jhc.heritrix.writer.extractor;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TaobaoItemExtractor implements Extractor {
	
	private Document doc;

	public TaobaoItemExtractor(Document doc) {
		this.doc = doc;
	}

	public String getCommodityName() {
		Element e = doc.select(".tb-detail-hd h3").first();
		return e.ownText().trim();
	}
}

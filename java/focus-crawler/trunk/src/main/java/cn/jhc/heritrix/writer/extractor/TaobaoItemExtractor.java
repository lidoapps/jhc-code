package cn.jhc.heritrix.writer.extractor;

import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TaobaoItemExtractor implements ItemExtractor {
	
	private Document doc;

	public TaobaoItemExtractor(Document doc) {
		this.doc = doc;
	}

	public String extractCommodityName() {
		Element e = doc.select(".tb-detail-hd h3").first();
		return e.ownText().trim();
	}

	public float extractMarketPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float extractMaxPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float extractPromotionPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String extractPromotionNote() {
		// TODO Auto-generated method stub
		return null;
	}

	public String extractSaledDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	public String extractAssessment() {
		// TODO Auto-generated method stub
		return null;
	}

	public String extractCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String> extractAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
}

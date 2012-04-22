package cn.jhc.heritrix.writer.extractor;

import java.util.Date;

import org.jsoup.nodes.Document;

public class TaobaoShopExtractor implements ShopExtractor {

	private Document doc;
	
	public TaobaoShopExtractor(Document doc) {
		this.doc = doc;
	}
	
	public String extractName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String extractUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String extractAssessment() {
		// TODO Auto-generated method stub
		return null;
	}

	public int extractAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Date extractCeateDate() {
		// TODO Auto-generated method stub
		return null;
	}

}

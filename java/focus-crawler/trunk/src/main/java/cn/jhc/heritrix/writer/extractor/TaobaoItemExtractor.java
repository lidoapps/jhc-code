package cn.jhc.heritrix.writer.extractor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.jhc.heritrix.db.dao.DAOFactory;
/**
 * 淘宝网商品信息网页的促销信息、顾客评价等信息在爬取时还未生成，页面使用的是Ajax请求。这些数据的获取留待将来解决。
 * @author luyanfei
 *
 */
public class TaobaoItemExtractor implements ItemExtractor {
	
	private final static long DEFAULT_CONTEXT_ID;
	
	static {
		DEFAULT_CONTEXT_ID = DAOFactory.getContextDAO().findSiteContextID(SiteURL.TAOBAO_URL);
	}
	
	private Document doc;

	public TaobaoItemExtractor(Document doc) {
		this.doc = doc;
	}

	public String extractCommodityName() {
		Element e = doc.select(".tb-detail-hd h3").first();
		return e.ownText().trim();
	}

	public float extractMarketPrice() {
		Element e = doc.select("#J_StrPrice").first();
		return Float.valueOf(e.ownText().split("-")[0].trim());
	}

	public float extractMaxPrice() {
		Element e = doc.select("#J_StrPrice").first();
		String[] s = e.ownText().split("-");
		return s.length<2 ? 0.0f : Float.valueOf(s[1].trim());
	}

	public float extractPromotionPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String extractPromotionNote() {
		// TODO Auto-generated method stub
		return "NOT FOUND";
	}

	public String extractSaledDesc() {
		// TODO Auto-generated method stub
		return "NOT FOUND";
	}

	public String extractAssessment() {
		// TODO Auto-generated method stub
		return "NOT FOUND";
	}

	public String extractCategory() {
		// TODO Auto-generated method stub
		return "NOT FOUND";
	}

	public Map<String, String> extractAttributes() {
		Map<String,String> map = new HashMap<String, String>();
		Elements attrs = doc.select(".attributes-list li");
		Iterator<Element> it = attrs.iterator();
		while(it.hasNext()) {
			//UTF-8编码中的C2A0（对应unicode中的00a0）非常特殊，需要替换掉
			String text = it.next().ownText().replace('\u00a0', ' ');
			//不能确定分号用的是全角还是半角
			String delimitor = "：";
			if(text.indexOf(":") != -1)
				delimitor = ":";
			String[] s = text.split(delimitor);
			//如果分割不对，忽略该组数据。以后考虑处理各种意外情况。
			if(s.length != 2)
				continue;
			map.put(s[0].replaceAll(" ", ""), s[1].trim());
		}
		return map;
	}

	public long extractContextId() {
		return DEFAULT_CONTEXT_ID;
	}
}

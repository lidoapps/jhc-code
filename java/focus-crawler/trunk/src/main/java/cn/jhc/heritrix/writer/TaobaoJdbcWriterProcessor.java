package cn.jhc.heritrix.writer;

import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import cn.jhc.heritrix.bean.CommodityInfo;
import cn.jhc.heritrix.db.dao.DAOFactory;

public class TaobaoJdbcWriterProcessor extends JdbcWriterProcessor {

	private static final long serialVersionUID = 3567651846232196014L;
	//提供商品信息的网页的URL模式
	private static final String URL_PATTERN = "^http://item\\.taobao\\.com/item\\.htm\\?id=\\d+";
	private static final Pattern PATTERN = Pattern.compile(URL_PATTERN);
	private static final String SITE_URL = "http://www.taobao.com/";
	private static int default_context_id = 0;
	
	public TaobaoJdbcWriterProcessor(String name) {
		super(name);
	}

	@Override
	public boolean validateUri(String uri) {
		return PATTERN.matcher(uri).matches();
	}

	@Override
	public long getDefaultContextId() {
		if(0 == default_context_id) {
			default_context_id = DAOFactory.getSiteDAO().findSite(SITE_URL).getId();
		}
		return default_context_id;
	}

	@Override
	public CommodityInfo extract(Document doc) {
		CommodityInfo cinfo = new CommodityInfo();
		cinfo.setName(getCommodityName(doc));
		
		return cinfo;
	}

	protected String getCommodityName(Document doc) {
		Element e = doc.select(".tb-detail-hd h3").first();
		return e.ownText().trim();
	}
	
}

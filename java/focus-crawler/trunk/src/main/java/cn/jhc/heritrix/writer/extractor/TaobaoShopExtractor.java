package cn.jhc.heritrix.writer.extractor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;

import cn.jhc.heritrix.db.dao.DAOFactory;

public class TaobaoShopExtractor implements ShopExtractor {

	private Document doc;
	private static final Pattern NUM_PATTERN = Pattern.compile("(\\d+)");
	private static final Pattern GIF_PATTERN = Pattern.compile("[a-z0-9_]+\\.gif$");
	private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final Logger logger = Logger.getLogger(TaobaoShopExtractor.class.getName());
	private static final int SITEID;
	
	static {
		SITEID = DAOFactory.getSiteDAO().findSite(SiteURL.TAOBAO_URL).getId();
	}
	
	public TaobaoShopExtractor(Document doc) {
		this.doc = doc;
	}
	
	public String extractName() {
		return doc.select(".shop-card a.hCard").first().ownText();
	}

	public String extractUrl() {
		String url = doc.select(".shop-card a.hCard").first().attr("href");
		Matcher matcher = SHOP_URL.matcher(url);
		return matcher.find() ? matcher.group() : "NOT FOUND";
	}

	/**
	 * 淘宝网中店铺的等级体系复杂，网页中的信息只是如下所示的一个img标签：
	 * <img src="http://pics.taobaocdn.com/newrank/s_blue_2.gif"  border="0" align="absmiddle" class="rank" />
	 * 此函数抽取的信息即为s_blue_2.gif，显示出来是两颗蓝钻。
	 */
	public String extractAssessment() {
		String src = doc.select("#shop-rank img").first().attr("src");
		Matcher matcher = GIF_PATTERN.matcher(src);
		return matcher.find() ? matcher.group() : "NO RANK";
	}

	public int extractAmount() {
		String itemnum = doc.select(".shop-details li.goodrate span.item-num").first().ownText().trim();
		Matcher matcher = NUM_PATTERN.matcher(itemnum);
		return matcher.find() ? Integer.valueOf(matcher.group()) : 0;
	}

	/**
	 * 提取店铺的创建时间，如果不能成功抽取，则返回new java.util.Date(0)。在中国正好是"1970-01-01 08:00:00"。
	 */
	public Date extractCreateDate() {
		String setuptime = doc.select(".shop-details li.setuptime").first().ownText().trim();
		Date date;
		try {
			date = DATEFORMAT.parse(setuptime);
		} catch (ParseException e) {
			logger.severe("Can not parse string \"" + setuptime + "\" as a java.util.Date object.");
			date = new Date(0);
		}
		return date;
	}

	public int extractSiteId() {
		return SITEID;
	}

}

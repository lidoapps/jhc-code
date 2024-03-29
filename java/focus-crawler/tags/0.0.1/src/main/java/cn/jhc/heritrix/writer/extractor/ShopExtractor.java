package cn.jhc.heritrix.writer.extractor;

import java.util.Date;
import java.util.regex.Pattern;

public interface ShopExtractor {
	public String extractName();
	public String extractUrl();
	public int extractSiteId();
	public String extractAssessment();
	public int extractAmount();
	public Date extractCreateDate();
	public static final Pattern SHOP_URL = Pattern.compile("^http://[^/]+/");
}

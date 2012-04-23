package cn.jhc.heritrix.writer.extractor;

import java.util.Date;
import java.util.regex.Pattern;

public interface ShopExtractor {
	public String extractName();
	public String extractUrl();
	public String extractAssessment();
	public int extractAmount();
	public Date extractCeateDate();
	public static final Pattern SHOP_URL = Pattern.compile("^http://[^/]+/");
}

package cn.jhc.heritrix.writer.extractor;

import java.util.Date;

public interface ShopExtractor {
	public String extractName();
	public String extractUrl();
	public String extractAssessment();
	public int extractAmount();
	public Date extractCeateDate();
}

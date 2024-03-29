package cn.jhc.heritrix.writer.extractor;

import java.util.Map;

public interface ItemExtractor {

	/**
	 * 抽取商品的名称
	 * @return
	 * 		商品名称。
	 */
	public String extractCommodityName();
	public long extractContextId();
	public float extractMarketPrice();
	public float extractMaxPrice();
	public float extractPromotionPrice();
	public String extractPromotionNote();
	public String extractSaledDesc();
	public String extractAssessment();
	public String extractCategory();
	public Map<String,String> extractAttributes();
}

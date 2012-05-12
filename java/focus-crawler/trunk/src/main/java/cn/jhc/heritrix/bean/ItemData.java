package cn.jhc.heritrix.bean;

public class ItemData {
	private float marketPrice;
	private float maxPrice;
	private float promotionPrice;
	private String promotionNote;
	private String saledDesc;
	private String assessment;
	private String url;
	private long contextId;

	public ItemData() {
	}

	public float getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public float getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(float promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public String getPromotionNote() {
		return promotionNote;
	}

	public void setPromotionNote(String promotionNote) {
		this.promotionNote = promotionNote;
	}

	public String getSaledDesc() {
		return saledDesc;
	}

	public void setSaledDesc(String saledDesc) {
		this.saledDesc = saledDesc;
	}

	public String getAssessment() {
		return assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getContextId() {
		return contextId;
	}

	public void setContextId(long contextId) {
		this.contextId = contextId;
	}
}
package cn.jhc.heritrix.bean;

import java.util.Date;

public class Gathering {

	private long id;
	private long commodityId;
	private long contextId;
	//市场价
	private float marketPrice;
	//最高价
	private float maxPrice;
	//促销价
	private float promotionPrice;
	//促销描述
	private String promotionNote;
	//销量描述
	private String saledDesc;
	//评价
	private String assessment;
	//url
	private String url;
	private Date dateTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}
	public long getContextId() {
		return contextId;
	}
	public void setContextId(long contextId) {
		this.contextId = contextId;
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
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
}

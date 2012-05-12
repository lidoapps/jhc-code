package cn.jhc.heritrix.bean;

import java.util.Date;

public class Gathering {

	
	private long id;
	private long commodityId;
	
	private ItemData itemData = new ItemData();
	
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
		return itemData.getContextId();
	}
	public void setContextId(long contextId) {
		this.itemData.setContextId(contextId);
	}
	public float getMarketPrice() {
		return itemData.getMarketPrice();
	}
	public void setMarketPrice(float marketPrice) {
		this.itemData.setMarketPrice(marketPrice);
	}
	public float getMaxPrice() {
		return itemData.getMaxPrice();
	}
	public void setMaxPrice(float maxPrice) {
		this.itemData.setMaxPrice(maxPrice);
	}
	public float getPromotionPrice() {
		return itemData.getPromotionPrice();
	}
	public void setPromotionPrice(float promotionPrice) {
		this.itemData.setPromotionPrice(promotionPrice);
	}
	public String getPromotionNote() {
		return itemData.getPromotionNote();
	}
	public void setPromotionNote(String promotionNote) {
		this.itemData.setPromotionNote(promotionNote);
	}
	public String getSaledDesc() {
		return itemData.getSaledDesc();
	}
	public void setSaledDesc(String saledDesc) {
		this.itemData.setSaledDesc(saledDesc);
	}
	public String getAssessment() {
		return itemData.getAssessment();
	}
	public void setAssessment(String assessment) {
		this.itemData.setAssessment(assessment);
	}
	public String getUrl() {
		return itemData.getUrl();
	}
	public void setUrl(String url) {
		this.itemData.setUrl(url);
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public ItemData getItemData() {
		return itemData;
	}
	public void setItemData(ItemData itemData) {
		this.itemData = itemData;
	}
	
}

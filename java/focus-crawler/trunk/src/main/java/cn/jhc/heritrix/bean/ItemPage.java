package cn.jhc.heritrix.bean;

import java.util.Map;
import java.util.Set;
/**
 * 代表商品网页，用于存放从网页中抽取出来的信息。
 * @author luyanfei
 *
 */
public class ItemPage {

	//商品名称
	private String name;
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
	//类别
	private String category;
	//各种属性
	private Map<String, String> attributes ;
	
	/**
	 * 放入一个属性，对底层HashMap的put方法的封装。
	 * @param name
	 * 		属性的名字。
	 * @param value
	 * 		属性的值。
	 */
	public void putAttribute(String name, String value) {
		this.attributes.put(name, value);
	}
	/**
	 * 读取一个属性，对底层HashMap的get方法的封装。
	 * @param name
	 * 		属性的名字。
	 * @return
	 * 		属性名对应的值。
	 */
	public String getAttribute(String name) {
		return this.attributes.get(name);
	}
	
	/**
	 * 获取所有键值对，对底层HashMap的entrySet方法的封装。
	 * @return
	 * 		所有属性的键值对。
	 */
	public Set<Map.Entry<String, String>> entrySet(){
		return attributes.entrySet();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
}

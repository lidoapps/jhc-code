package cn.jhc.heritrix.bean;

import java.util.Map;
import java.util.Set;
/**
 * 代表商品网页，用于存放从网页中抽取出来的信息。
 * @author luyanfei
 *
 */
public class ItemPage {
	/**
	 * 对于“品牌+型号（或货号）”的表示方法，用下面变量指定的字符进行分隔。
	 */
	public static final String delimitor = "::";

	//商品名称
	private String name;
	
	//ItemPage和Gathering共享字段的封装
	private ItemData itemData = new ItemData();

	//类别
	private String category;
	//各种属性
	private Map<String, String> attributes ;
	
	/**
	 * 提取属性中含有指定字符串的属性的值。如果有e多个，只返回第一个。指定字符串可以是“品牌”，“ISBN”，“ISRC”等。
	 * @param s
	 * 		在属性名中包含的字符串。
	 * @return
	 * 		含有指定字符串的属性的值，如果无法找到类似的属性，则返回null。
	 */
	public String containsSpecialValue(String s) {
		for(String key : attributes.keySet())
			if(key.toLowerCase().contains(s.toLowerCase()))
				return attributes.get(key);
		return null;
	}
	/**
	 * 提取商品的instance_id，其算法如下：
	 * 如果有ISBN或ISRC属性，则instance_id即是ISBN或ISRC。
	 * 否则提取"品牌::型号"。
	 * 如果上面的属性都没有，返回null。
	 * @return
	 * 		商品的instance_id。
	 */
	public String getInstanceId() {
		String instanceId = null;
		for(String key : attributes.keySet()) {
			if(key.toLowerCase().contains("isbn")) {
				instanceId = attributes.get(key);
				break;
			}
			if(key.toLowerCase().contains("isrc")) {
				instanceId = attributes.get(key);
				break;
			}
			if(key.contains("型号") || key.contains("货号")) {
				String brand = getBrandName();
				if(brand != null) {
					instanceId = brand + "::" + attributes.get(key);
					break;
				}
			}
		}
		return instanceId;
	}
	
	public String getBrandName() {
		return containsSpecialValue("品牌");
	}
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
	public long getContextId() {
		return itemData.getContextId();
	}
	public void setContextId(long contextId) {
		this.itemData.setContextId(contextId);
	}
	public ItemData getItemData() {
		return itemData;
	}
	public void setItemData(ItemData itemData) {
		this.itemData = itemData;
	}
	
}

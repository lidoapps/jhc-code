package cn.jhc.heritrix.bean;

public class GatherMeta {
	private long id;
	private long gatherId;
	private String key;
	private String value;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getGatherId() {
		return gatherId;
	}
	public void setGatherId(long gatherId) {
		this.gatherId = gatherId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}

package cn.jhc.heritrix.bean;

import java.util.Date;

public class Shop {
	private long id;
	private String name;
	private String url;
	private int siteId;
	private String assessment;
	private int amount;
	private Date createDate;
	private Date datetime;

	public Shop() {
	}

	public Shop(String name, String url, int siteId, String assessment,
			int amount, Date createDate) {
		super();
		this.name = name;
		this.url = url;
		this.siteId = siteId;
		this.assessment = assessment;
		this.amount = amount;
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAssessment() {
		return assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
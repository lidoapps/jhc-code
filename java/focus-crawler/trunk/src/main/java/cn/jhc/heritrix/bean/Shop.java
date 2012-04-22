package cn.jhc.heritrix.bean;

import java.util.Date;

public class Shop {
	private String name;
	private String url;
	private String assessment;
	private int amount;
	private Date ceateDate;

	public Shop() {
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

	public Date getCeateDate() {
		return ceateDate;
	}

	public void setCeateDate(Date ceateDate) {
		this.ceateDate = ceateDate;
	}

}
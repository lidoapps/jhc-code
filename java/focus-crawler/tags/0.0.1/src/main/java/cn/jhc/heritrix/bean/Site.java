package cn.jhc.heritrix.bean;

import java.util.Date;

public class Site {

	private int id;
	private String name;
	private String fullname;
	private String url;
	private Date datetime;
	
	public Site() {}
	
	public Site(String name, String fullname, String url) {
		this.name = name;
		this.fullname = fullname;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}

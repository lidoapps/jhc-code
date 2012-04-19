package cn.jhc.heritrix.db.bean;

import java.util.Date;

public class Context {
	private long id;
	private String path;
	private long instanceID;
	private int contextLevel;
	private Date datetime;
	
	public Context() {}
	
	
	public Context(String path, long instanceID, int contextLevel) {
		super();
		this.path = path;
		this.instanceID = instanceID;
		this.contextLevel = contextLevel;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getInstanceID() {
		return instanceID;
	}
	public void setInstanceID(long instanceID) {
		this.instanceID = instanceID;
	}
	public int getContextLevel() {
		return contextLevel;
	}
	public void setContextLevel(int contextLevel) {
		this.contextLevel = contextLevel;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}

package com.cwq.emp.dto;

import java.io.Serializable;

public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pageno;
	private int flag;
	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
	/**
	 * @return the pageno
	 */
	public String getPageno() {
		return pageno;
	}
	/**
	 * @param pageno the pageno to set
	 */
	public void setPageno(String pageno) {
		this.pageno = pageno;
	}
	

}

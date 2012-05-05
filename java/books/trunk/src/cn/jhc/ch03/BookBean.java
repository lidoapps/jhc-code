/*
 * cn.jhc.ch03.BookBean.java
 * Y2javaee的ch03的示例，演示购物车
 */
package cn.jhc.ch03;

import java.io.Serializable;

public class BookBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ISBN;// ISBN编号

	private String title;// 书名

	private String copyright;// 版权

	private String imageFile;// 封面图像

	private int editionNumber;// 版本

	private int publisherID;// 出版商ID

	private double price;// 价格

	
	/**
	 * 返回版权
	 * @return
	 */public String getCopyright() {
		return copyright;
	}
	
	/**
	 * 设定版权
	 * @param copyright
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	
	/**
	 * 返回版本
	 * @return
	 */
	public int getEditionNumber() {
		return editionNumber;
	}

	/**
	 * 设定版本
	 * @param editionNumber
	 */
	public void setEditionNumber(int editionNumber) {
		this.editionNumber = editionNumber;
	}
	
	/**
	 *  返回封面图像文件名
	 * @return
	 */
	public String getImageFile() {
		return imageFile;
	}
	
	/**
	 * 设定封面图像文件名
	 * @param imageFile
	 */
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	/**
	 * 返回ISBN编号
	 * @return
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * 设定ISBN编号
	 * @param isbn
	 */
	public void setISBN(String isbn) {
		ISBN = isbn;
	}
	
	
	/**
	 * 返回价格
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * 设定价格
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 返回出版商ID
	 * @return
	 */
	public int getPublisherID() {
		return publisherID;
	}

	/**
	 *  设定出版商ID
	 * @param publisherID
	 */
	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}
	
	/**
	 * 返回书名
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设定书名
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}

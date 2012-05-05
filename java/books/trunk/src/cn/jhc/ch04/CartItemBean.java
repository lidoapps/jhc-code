/*
 * cn.jhc.ch04.CartItemBean.java
 * Y2javaee的ch04示例，演示购物车
 */
package cn.jhc.ch04;

import java.io.Serializable;

import cn.jhc.ch03.BookBean;


public class CartItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private BookBean book;// 当前书籍

	private int quantity;// 购物车中的数量

	/**
	 * 初始化 CartItemBean
	 * 
	 * @param bookToAdd
	 * @param number
	 */
	public CartItemBean(BookBean bookToAdd, int number) {
		book = bookToAdd;
		quantity = number;
	}

	/**
	 * 返回book
	 * 
	 * @return
	 */
	public BookBean getBook() {
		return book;
	}

	/**
	 * 设定数量
	 * 
	 * @param number
	 */
	public void setQuantity(int number) {
		quantity = number;
	}

	/**
	 * 返回数量
	 * 
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}
}

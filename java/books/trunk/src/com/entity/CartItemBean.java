package com.entity;

import java.io.Serializable;
import com.entity.BookBean;

public class CartItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private BookBean book;

	private int quantity;

	/**
	 * @return book
	 */
	public BookBean getBook() {
		return book;
	}

	/**
	 * @param book
	 *            要设置的 book
	 */
	public void setBook(BookBean book) {
		this.book = book;
	}

	/**
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            要设置的 quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartItemBean(com.entity.BookBean book, int number) {
		this.book = book;
		this.quantity = number;
	}

}

/*
 * cn.jhc.ch05.AddBookToCart.java
 * Y2javaee的ch05示例，演示购物车
 */
package cn.jhc.ch08;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jhc.ch03.BookBean;
import cn.jhc.ch04.CartItemBean;


public class AddBookToCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddBookToCart() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		RequestDispatcher dispatcher;

		// 如果session不存在，转向 /ch04/books.jsp
		if (session == null) {
			dispatcher = request.getRequestDispatcher("/ch04/books.jsp");
			dispatcher.forward(request, response);
		}

		// 取出购物车和添加的书籍
		Map cart = (Map) session.getAttribute("cart");
		BookBean book = (BookBean) session.getAttribute("bookToAdd");

		// 如果购物车不存在，创建购物车
		if (cart == null) {
			cart = new HashMap();

			// 将购物车存入session之中
			session.setAttribute("cart", cart);
		}

		// 判断书籍是否在购物车中
		CartItemBean cartItem = (CartItemBean) cart.get(book.getISBN());

		// 如果书籍在购物车中，更新其数量.
		// 否则，创建一个条目到Map中.
		if (cartItem != null)
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		else
			cart.put(book.getISBN(), new CartItemBean(book, 1));

		// 转向viewCart.jsp显示购物车
		dispatcher = request.getRequestDispatcher("/ch08/viewCart.jsp");
		dispatcher.forward(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}

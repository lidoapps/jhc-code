<%@ page language="java" session="true" pageEncoding="UTF-8"%>
<%@ page import="cn.jhc.ch03.*"%>
<%@ page import="cn.jhc.ch04.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<!-- viewCart.jsp -->

<%-- JSP page settings --%>     

<html xmlns = "http://www.w3.org/1999/xhtml">

<head>
   <title>Shopping Cart</title>

<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<link href="/books/images/main.css" type=text/css rel=stylesheet>
</head>

<body>



<center>
<table cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff 
background=/books/images/top1bg.jpg border=0>
  <tbody>
  <tr>
    <td width=778>&nbsp;</td></tr></tbody></table>
<table class=center height=100 cellSpacing=0 cellPadding=0 width=778 
bgColor=#ffffff border=0>
  <tbody>
  <tr>
    <td align=middle width=150><img 
      title="" height=100 
      src="/books/images/logo.jpg" width=100 border=0></td>
    <td width=58>&nbsp;</td>
    <td vAlign=top width=110><img
      height=90 src="/books/images/top1.jpg" width=70 border=0></td>
    <td vAlign=top width=110><img 
      height=90 src="/books/images/top2.jpg" width=70 border=0></td>
    <td vAlign=top width=110><img 
       height=90 src="/books/images/top3.jpg" width=70 
      border=0></td>
    <td vAlign=top width=110><img 
      height=90 src="/books/images/top4.jpg" width=70 border=0></td>
    <td width=130>
     </td></tr></tbody></table>

<table class=center cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff 
border=0>
  <tbody><tr>
    <td style="FONT-SIZE: 1px" bgColor=#b0b0b0 colSpan=19 
  height=1></td></tr></tbody></table>
<table cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
  <tbody>
  <tr>
    <td style="FONT-SIZE: 1px" bgColor=#dcdcdc height=3></td></tr>
  <tr>
    <td align=right background=/books/images/bn01.gif height=120>&nbsp;</td>
  </tr></tbody></table>

<table height=15 cellSpacing=0 cellPadding=0 width=778 border=0>
  <tbody>
  <tr>
    <td style="FONT-SIZE: 10px; LINE-HEIGHT: 10px" 
    background=/books/images/bnbg1.gif height=15></td></tr></tbody></table>
<table cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0 height="357">
  <tbody>
  <tr>
    <td vAlign=top width=168 height=400>
      <table class=center height="100%" cellSpacing=0 cellPadding=0 width=168 
      bgColor=#ffffff background=/books/images/leftbg.gif border=0>
        <tbody>
       
        <tr>
          <td class=lefttd vAlign=top align=middle><br>
            </td></tr></tbody></table></td>
    <td vAlign=top align=middle width=610>
      <table cellSpacing=0 cellPadding=0 width="98%" 
      background=/books/images/top01.gif border=0>
        <tbody>
        <tr>
          <td align=left height=25><img height=11 src="/books/images/icon1.gif" 
            width=31>　购物车内商品：</td></tr></tbody></table><br>
      <table style="TEXT-ALIGN: center" cellSpacing=0 cellPadding=0 width=590 
      border=0>
        <tbody>


<!--   显示内容开始  -->



<%-- start scriptlet to display shopping cart contents --%>
<%  
	Map cart = (Map) session.getAttribute("cart");
	double total = 0;

	if (cart == null || cart.size() == 0)
		out.println("<p>购物车当前为空.</p>");
	else {

		// 创建用于显示内容的变量
		Set cartItems = cart.keySet();
		//Iterator iterator = cartItems.iterator();
		Object[] isbn = cartItems.toArray();
		BookBean book;
		CartItemBean cartItem;

		int quantity;
		double price, subtotal;
%>
 <%-- end scriptlet for literal XHTML output --%>

   <table cellSpacing=0 cellPadding=0
				width=590 border=1>
      <thead><tr align="center">
         <th>书籍名称</th>
         <th>数量</th>
         <th>价格</th>
         <th>小计</th>
      </tr></thead>

<% // continue scriptlet 

			int i = 0;
			while (i < isbn.length) {

				// 计算总和
				cartItem = (CartItemBean) cart.get((String)isbn[i]);
				book = cartItem.getBook();
				quantity = cartItem.getQuantity();
				price = book.getPrice();
				subtotal = quantity * price;
				total += subtotal;
				i++;

%> <%-- end scriptlet for literal XHTML and   --%>
   <%-- JSP expressions output from this loop --%>

         <%-- display table row of book title, quantity, --%>
         <%-- price and subtotal --%>
         <tr>
            <td><%= book.getTitle() %></td>

            <td align="center"><%= quantity %></td>

            <td class = "right">
               <%= 
                  new DecimalFormat( "0.00" ).format( price )
               %>
            </td>

            <td class = "bold right">
               <%= 
                  new DecimalFormat( "0.00" ).format( subtotal ) 
               %>
            </td>
         </tr>

<% // continue scriptlet 

      }  // end of while loop

%> <%-- end scriptlet for literal XHTML and   --%>

      <%-- display table row containing shopping cart total --%>
      <tr>
         <td colspan = "4" class = "bold right"><b>&#24635;&#35745;&#65306;  </b>
            <%= new DecimalFormat( "0.00" ).format( total ) %>
         </td>
      </tr>
   </table>

<% // continue scriptlet 

      // make current total a session attribute
      session.setAttribute( "total", new Double( total ) );
   }  // end of else

%> <%-- end scriptlet --%>

   <!-- link back to books.jsp to continue shopping -->
   <p class = "bold green">
      <a href = "/books/ch08/books.jsp">继续购物</a>
   </p>

   <!-- form to proceed to checkout -->
   <form method = "get" action = "/books/ch08/order.html">
      <p><input type = "submit" value = "结 账" /></p>
   </form>

<!--   显示内容结束  -->
				 </tbody>
				 </table>
      <br></td></tr></tbody></table>
<table class=center cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff 
border=0>
  <tbody>
  <tr>
    <td align=middle background=/books/images/bk.gif height=50>
    </td></tr></tbody></table>

</center></body></html>



<!--
 ***************************************************************
 * (C) Copyright 2001 by Deitel & Associates, Inc. and         *
 * Prentice Hall. All Rights Reserved.                         *
 *                                                             *
 * DISCLAIMER: The authors and publisher of this book have     *
 * used their best efforts in preparing the book. These        *
 * efforts include the development, research, and testing of   *
 * the theories and programs to determine their effectiveness. *
 * The authors and publisher make no warranty of any kind,     *
 * expressed or implied, with regard to these programs or to   *
 * the documentation contained in these books. The authors     *
 * and publisher shall not be liable in any event for          *
 * incidental or consequential damages in connection with, or  *
 * arising out of, the furnishing, performance, or use of      *
 * these programs.                                             *
 ***************************************************************
-->
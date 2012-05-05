<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="cn.jhc.ch03.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

<title>书籍信息</title>

<!-- <link rel="stylesheet" href="./styles.css" type="text/css" />    -->
<link href="/books/images/main.css" type="text/css" rel="stylesheet" />

<c:set var="isbn" value="${param.isbn}"></c:set>
<c:forEach var="currentBook" items="${sessionScope.bookTitles}">
	<c:if test="${isbn==currentBook.ISBN}">
		<c:set var="bookToAdd" value="${currentBook}" scope="session" />
	</c:if>
</c:forEach>
</head>

<body>
<p class="bigFont"><br></p>
			<center>
					<table cellSpacing="0" cellPadding="0" width="778"
						bgColor="#ffffff" background="/books/images/top1bg.jpg" border="0">
						<tbody>
							<tr>
								<td width="778"></td>
							</tr>
						</tbody>
					</table>
					<table class="center" height="100" cellSpacing="0"
						cellPadding="0" width="778" bgColor="#ffffff" border="0">
						<tbody>
							<tr>
								<td align="middle" width="150">
									<img title="" height="100"
										src="/books/images/logo.jpg" width="100" border="0" />
								</td>
								<td width="58"></td>
								<td vAlign="top" width="110">
									<img height="90"
										src="/books/images/top1.jpg" width="70" border="0" />
								</td>
								<td vAlign="top" width="110">
									<img height="90"
										src="/books/images/top2.jpg" width="70" border="0" />
								</td>
								<td vAlign="top" width="110">
									<img height="90"
										src="/books/images/top3.jpg" width="70" border="0" />
								</td>
								<td vAlign="top" width="110">
									<img height="90"
										src="/books/images/top4.jpg" width="70" border="0" />
								</td>
								<td width="130"></td>
							</tr>
						</tbody>
					</table>

					<table class="center" cellSpacing="0"
						cellPadding="0" width="778" bgColor="#ffffff" border="0">
						<tbody>
							<tr>
								<td style="FONT-SIZE: 1px"
									bgColor="#b0b0b0" colSpan="19" height="1">
								</td>
							</tr>
						</tbody>
					</table>
					<table cellSpacing="0" cellPadding="0" width="778"
						bgColor="#ffffff" border="0">
						<tbody>
							<tr>
								<td style="FONT-SIZE: 1px"
									bgColor="#dcdcdc" height="3">
								</td>
							</tr>
							<tr>
								<td align="right"
									background="/books/images/bn01.gif" height="120">
								</td>
							</tr>
						</tbody>
					</table>

					<table height="15" cellSpacing="0" cellPadding="0"
						width="778" border="0">
						<tbody>
							<tr>
								<td
									style="FONT-SIZE: 10px; LINE-HEIGHT: 10px"
									background="/books/images/bnbg1.gif" height="15">
								</td>
							</tr>
						</tbody>
					</table>
					<table cellSpacing="0" cellPadding="0" width="778"
						bgColor="#ffffff" border="0">
						<tbody>
							<tr>
								<td vAlign="top" width="168"
									height="400">
									<table class="center" height="100%"
										cellSpacing="0" cellPadding="0" width="168" bgColor="#ffffff"
										background="/books/images/leftbg.gif" border="0">
										<tbody>

											<tr>
												<td class="lefttd"
													vAlign="top" align="middle">
													<br />
												</td>
											</tr>
										</tbody>
									</table>
								</td>
								<td vAlign="top" align="middle"
									width="610">
									<table cellSpacing="0"
										cellPadding="0" width="98%" background="/books/images/top01.gif"
										border="0">
										<tbody>
											<tr>
												<td align="left"
													height="25">
													<img height="11"
														src="/books/images/icon1.gif" width="31" />
													<font style="cursor:hand" onclick="javascript:history.go(-1);">返回</font>
												</td>
											</tr>
										</tbody>
									</table>
									<br />
									<table style="TEXT-ALIGN: center"
										cellSpacing="0" cellPadding="0" width="590" border="0">
										<tbody>
											<tr height="100">
												<td colspan="3">
												<h2>${bookToAdd.title }</h2>
												</td>
											</tr>
											
											<tr>
												<!-- create table cell for product image -->
												<td rowspan="5"><!-- cell spans 5 rows -->
													<img
														style="border: thin solid black"
														src="/books/images/${bookToAdd.imageFile }" alt="${bookToAdd.title }" />
												</td>

												<!-- create table cells for price in row 1 -->
												<td class="bold" align="left">
													图书编号：
												</td>

												<td align="left">
													${bookToAdd.ISBN} }
												</td>
											</tr>

											<tr align="left">

												<!-- create table cells for ISBN in row 2 -->
												<td class="bold"  align="left">
													价格：
												</td>

												<td  align="left">
													${bookToAdd.price} }
												</td>
												
											</tr>

											<tr  align="left">

												<!-- create table cells for edition in row 3 -->
												<td class="bold">
													版本号：
												</td>

												<td>
													${bookToAdd.editionNumber }
												</td>
											</tr>

											<tr align="left">

												<!-- create table cells for copyright in row 4 -->
												<td class="bold">
													版权：
												</td>

												<td>
													${bookToAdd.copyright }
												</td>
											</tr>

											<tr align="left">
												<!-- create Add to Cart button in row 5 -->
												<td>
													<form method="post"
														action="/books/AddBookToCart4">
														<p>
															<input
																type="submit" value="放入购物车" />
														</p>
													</form>
												</td>

												<!-- create View Cart button in row 5 -->
												<td>
													<form method="get"
														action="viewCart.jsp">
														<p>
															<input
																type="submit" value="查看购物车" />
														</p>
													</form>
												</td>
											</tr>





										</tbody>
									</table>
									<br />
								</td>
							</tr>
						</tbody>
					</table>
					<table class="center" cellSpacing="0"
						cellPadding="0" width="778" bgColor="#ffffff" border="0">
						<tbody>
							<tr>
								<td align="middle"
									background="/books/images/bk.gif" height="50">
								</td>
							</tr>
						</tbody>
					</table>

				</center>
<body>&nbsp;</body>

</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Cart Application</title>
</head>
<body>
	<h1>View Cart</h1>
	<h2>Items in Your Cart</h2>
	<a href="${flowExecutionUrl}&_eventId=submit">Submit</a>
	<h2>Products for Your Choice</h2>
	<table>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.description}</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>


</html>

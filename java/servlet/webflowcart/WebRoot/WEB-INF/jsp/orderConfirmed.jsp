<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Cart Application</title>
  </head>
  <body>
    <h1>Order Confirmed</h1>
    <a href="${flowExecutionUrl }&_eventId=returnToIndex">Return to Index</a>
  </body>

</html>

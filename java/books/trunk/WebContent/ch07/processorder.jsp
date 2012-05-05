<%@ page language="java" pageEncoding="UTF-8"%>
<html>
  <head>   
    <title>演示JavaBean</title>
    
    <jsp:useBean id="order" class="cn.jhc.ch07.Order" scope="request"/>
    
    <jsp:setProperty name="order" property="username" param="username"/>
    <jsp:setProperty name="order" property="zipcode" param="zipcode"/>
    <jsp:setProperty name="order" property="phone" param="phone"/>
    <jsp:setProperty name="order" property="creditcard" param="creditcard"/>
    <jsp:setProperty name="order" property="total" value="23.45"/>
  
  </head>
  
  <body>
    用户名：<jsp:getProperty name="order" property="username"/>. <br>
    邮　编：<jsp:getProperty name="order" property="zipcode"/>. <br>
    电  话：<jsp:getProperty name="order" property="phone"/>. <br>
    信用卡：<jsp:getProperty name="order" property="creditcard"/>. <br>
    总　价：<jsp:getProperty name="order" property="total"/>. <br>
    
  </body>
</html>

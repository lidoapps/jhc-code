<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pagingEmp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table border=1>
       <tr>
          <td>EMPNO</td><td>ENAME</td><td>HIREDATE</td><td>JOB</td><td>SAL</td>
       </tr>
       <c:forEach var="e" items="${emps}">
          <tr>
            <td>${e.empno}</td> 
            <td>${e.ename}</td>
            <td>${e.hiredate}</td>
            <td>${e.job}</td>
            <td>${e.sal}</td>
         </tr>
       </c:forEach>
    </table>
  </body>
</html>

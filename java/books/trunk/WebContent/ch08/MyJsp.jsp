<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
  <head>
    <title>MyJsp</title>    
  </head>
<body>

	<c:set var= "example" value="${100+1}" scope="session"  />	
	
	<c:out value="${example}"/>
	
	<c:remove var= "example" scope="session"/>
	
	
	<%!
	String[] names={"a","b","c"};
	 %>
	
	<c:forEach var="name" items="${applicationScope.names }">
		${name }
	</c:forEach>
</body>	
</html>

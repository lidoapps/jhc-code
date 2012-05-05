<%@ page contentType="text/html;charSet=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="userManager" class="cn.jhc.ch07.UserManager"
	scope="request" />

<jsp:setProperty name="userManager" property="name" param="loginName" />
<jsp:setProperty name="userManager" property="password" param="password" />

<c:if test="${userManager.valid}">
	<jsp:forward page="books2.jsp" />
</c:if>
<c:if test="${!userManager.valid}">
	<jsp:forward page="register2.html" />
</c:if>


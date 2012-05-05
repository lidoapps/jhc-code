<%@ page contentType="text/html;charSet=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="userManager" class="cn.jhc.ch07.UserManager" scope="session"/>

<jsp:setProperty name="userManager" property="name" param="loginName" />
<jsp:setProperty name="userManager" property="password" param="password" />

<%
if (userManager.getValid()) {
%>
<jsp:forward page="books.jsp" />
<%
} else {
%>
<jsp:forward page="register.html" />
<%
}
%>

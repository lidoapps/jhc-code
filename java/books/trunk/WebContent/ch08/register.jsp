<%@ page contentType="text/html;charSet=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="UserManager" class="cn.jhc.ch07.UserManager" scope="session"/>

<jsp:setProperty name="UserManager" property="name" param="loginName" />
<jsp:setProperty name="UserManager" property="password" param="password" />

<%
if (UserManager.getValid()) {
%>
<jsp:forward page="books.jsp" />
<%
} else {
%>
<jsp:forward page="register.html" />
<%
}
%>

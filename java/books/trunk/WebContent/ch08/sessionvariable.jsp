<%@page contentType="text/html; charset=GBK"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
该 JSP 页面在一个 session 范围内的变量中存储 sessionvariable，此 Web 应用程序中的其他 JSP 页面可以访问此变量。
<p/>
<c:set var="sessionvariable" value="${80+8-7*6}" scope="session"/>
在删除 sessionvariable 之前先显示它的值：
<c:out value="${sessionvariable}"/>
<c:remove var="sessionvariable" scope="session"/>
<br/>
删除sessionvariable后的显示值：
<br/>
<c:out value="${sessionvariable}">sessionvariable为NULL</c:out>
</body>
</html>

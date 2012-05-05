<%@page contentType="text/html; charset=GBk" %>
<html>
<head>
<title>在 JSP 中使用 JavaBean</title>
<jsp:useBean id="bean" class="cn.jhc.ch07.Simplebean" scope="request"/>
<jsp:setProperty name="bean" property="name" value="${param.username}"/>
<jsp:setProperty name="bean" property="age" value="25"/>
</head>
<body>  姓名：
<jsp:getProperty name="bean" property="name"/>
<br/>
  年龄：
<jsp:getProperty name="bean" property="age"/>
</body>
</html>

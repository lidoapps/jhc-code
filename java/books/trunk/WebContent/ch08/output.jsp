<%@page contentType="text/html; charset=GBk"%>

<html>
<head>
<title>EL的使用</title>
<jsp:useBean id="bean" class="cn.jhc.ch07.Simplebean"
	scope="request" />
<jsp:setProperty name="bean" property="name" value="${param.name }" />
<jsp:setProperty name="bean" property="age" value="25" />
</head>
<body>
姓名：${bean.name } <br />
年龄：${bean.age + 15 } <br />
姓名：${bean["name"] } <br />
年龄：${bean["age"] + 15 } <br />
</body>
</html>

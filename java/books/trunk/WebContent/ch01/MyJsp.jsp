<%@ page import="java.util.*,java.text.*" pageEncoding="UTF-8"%>

<html>
<head>
<title>MyJSP </title>
</head>

<body>
你好，ACCP！
<br>
今天是
<%
	Date now = new Date();
	SimpleDateFormat formater = new SimpleDateFormat
	("yyyy年MM月dd日");
	String strCurrentTime = formater.format(now);

	out.println(strCurrentTime);
%>
</body>
</html>

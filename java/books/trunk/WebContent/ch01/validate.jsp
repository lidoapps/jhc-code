<%@ page contentType="text/html;charSet=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("GBK");
	response.setContentType("text/html;charSet=GBK");

	String pass = request.getParameter("password");
	String user = request.getParameter("loginName");
	
	
	if (user.equals("accp") && pass.equals("accp")) {
		System.out.println("登录成功!");
		out.print("登录成功!");
	} else {
		System.out.println("登录失败!");
		out.print("登录失败!");
	}
%>


<%@ page contentType="text/html;charSet=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="cn.jhc.ch05.ConnectionManager"%>
<%@ page import="cn.jhc.ch05.User"%>

<%
	request.setCharacterEncoding("GBK");

	String pass = request.getParameter("password");
	String user = request.getParameter("loginName");
	
	String sql = "select * from userinfo where loginname = ?";
	Connection con = ConnectionManager.getConnction();
	PreparedStatement pStatement = con.prepareStatement(sql);
	pStatement.setString(1, user);

	ResultSet rs = pStatement.executeQuery();
	if (rs.next() && rs.getString("password").equals(pass)) {
		System.out.println("鐧诲綍鎴愬姛!");
		User logineduser = new User(user, pass);
		session.setAttribute("LOGINED_USER", logineduser);
		response.sendRedirect("books.jsp");
	} else {
		System.out.println("鐧诲綍澶辫触!");
		response.sendRedirect("register.html");
	}
%>


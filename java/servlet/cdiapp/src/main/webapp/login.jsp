<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="user" class="cn.jhc.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="user" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<c:choose>
		<c:when test="${ !loginManager.login(user) }">
			<div id="logingform">
				<form method="get">
					<label for="name">用户名：</label> <input type="text" name="name"></input><br />
					<label for="password">密码：</label> <input type="password"
						name="password"></input><br /> <input type="submit" value="提交" />
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<jsp:forward page="/welcome.jsp"></jsp:forward>
		</c:otherwise>
	</c:choose>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'pagingEmp1.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<table border=1 width=100%>
			<caption Style="font-size: 30">
				EMP PAGING
			</caption>
			<tr>
				<td colspan=6 valign=middle align=right style="font-size: 25">
					Current Page:${currentPage},Total Pages:${totalPageCounts}</td>
			</tr>

			<tr bgcolor=grey>
				<td>
					INDEX
				</td>
				<td>
					EMPNO
				</td>
				<td>
					ENAME
				</td>
				<td>
					HIREDATE
				</td>
				<td>
					JOB
				</td>
				<td>
					SAL
				</td>
			</tr>

			<c:forEach var="emp" items="${emps}" varStatus="s">
			<tr>
				<td>${(currentPage - 1) * pagesize+s.index+1}</td>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.hiredate}</td>
				<td>${emp.sal}</td>
			</tr>
			</c:forEach>
		</table>
		<table border=0>
			<tr style="font-size: 30;">
				<td valign=top align=right>
                <div >
                    <c:if test="${currentPage == 1}">
                    first previous
                    </c:if>
                    <c:if test="${currentPage != 1}">
                    <a href=EmpPaging?pageno=1>first</a>
					<a href='EmpPaging?pageno=${currentPage - 1}' >previous</a>
                    </c:if>
					<c:if test="${currentPage >= totalPageCounts}">
					next last
					</c:if>
					<c:if test="${currentPage < totalPageCounts}">
					<a href='EmpPaging?pageno=${currentPage + 1}'>next</a>
					<a href='EmpPaging?pageno=${totalPageCounts}'>last</a>
					</c:if>
					
					</div>
				    <div>
					<form action=EmpPaging method=get>
						<select name=page onchange=document.forms[0].submit()>
							<c:forEach var="page" items="${pages}">
							   <c:if test="${page.flag==1}">
							  <option value=${page.pageno} selected>${page.pageno}</option>
							  </c:if>
							   <c:if test="${page.flag==0}">
							  <option value=${page.pageno}>${page.pageno}</option>
							  </c:if>
							</c:forEach>
						</select>
					</form>
					</div>
				</td>
				
			</tr>
		</table>
	</body>
</html>

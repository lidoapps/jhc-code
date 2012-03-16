<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.cwq.emp.dto.EmpDTO"%>
<%@ page import="com.cwq.emp.dao.EmpDao;"%>
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

		<title>My JSP 'pagingEmp2.jsp' starting page</title>

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
			<%
				int pagesize = ((Integer) request.getAttribute("pagesize"))
						.intValue();
				int totalPageCounts = ((Integer) request
						.getAttribute("totalPageCounts")).intValue();
				//System.out.print(totalPageCounts);
				int currentPage = 1;
				if (request.getAttribute("currentPage") != null) {
					currentPage = ((Integer) request.getAttribute("currentPage"))
					.intValue();
				}
			%>
			<tr>
				<td colspan=6 valign=middle align=right style="font-size: 25">
					Current Page:<%=currentPage%>,Total Pages:<%=totalPageCounts%></td>
			</tr>

			<tr bgcolor=grey>
				<td>INDEX</td><td>EMPNO</td><td>ENAME</td><td>HIREDATE</td><td>JOB</td><td>SAL</td>
			</tr>

			<%
			   ArrayList<EmpDTO> emps = (ArrayList<EmpDTO>) request.getAttribute("emps");
				for (int i = 0; i < emps.size(); i++) {
					EmpDTO emp = emps.get(i);
			%>
			<tr>
				<td><%= (currentPage - 1) * pagesize + i + 1%></td>
				<td><%=emp.getEmpno()%></td>
				<td><%=emp.getEname()%></td>
				<td><%=emp.getHiredate()%></td>
				<td><%=emp.getJob()%></td>
				<td><%=emp.getSal()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<table border=0>
			<tr style="font-size: 30;">
				<td valign=top align=right>
                <div >
					<%
					if (currentPage == 1) {
					%>
					first previous
					<%
					} else {
					%>
					<a href=EmpPaging?pageno=1>first</a>
					<a href=EmpPaging?pageno=<%=currentPage - 1%>>previous</a>
					<%
					}
					%>
					<%
					if (currentPage >= totalPageCounts) {
					%>
					next last
					<%
					} else {
					%>
					<a href=EmpPaging?pageno=<%=currentPage + 1%>>next</a>
					<a href=EmpPaging?pageno=<%=totalPageCounts%>>last</a>
					<%
					}
					%>
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

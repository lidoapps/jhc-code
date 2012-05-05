<%@page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="sessionperson" class="cn.jhc.ch08.Person" scope="session"/>
<jsp:useBean id="requestperson" class="cn.jhc.ch08.Person" scope="request"/>
<html>
<head>
<title>JSP EL隐式对象</title>
</head>
<c:set var="num" value="2" scope="page" />
<body>
<h2>JSP EL隐式对象</h2>
<table>
  <tr>
    <td>概念</td>
    <td>代码</td>
    <td>输出</td>
  </tr>
  <tr>
    <td>PageContext</td>
    <td>${'${'}      pageContext.request.requestURI}
</td>
    <td>${pageContext.request.requestURI}    </td>
  </tr>
  <tr>
    <td>sessionScope</td>
    <td>${'${'}      sessionScope.sessionperson.name}
</td>
    <td>${sessionScope.sessionperson.name}    </td>
  </tr>
  <tr>
    <td>requestScope</td>
    <td>${'${'}      requestScope.requestperson.name}
</td>
    <td>${requestScope.requestperson.name}    </td>
  </tr>
  <tr>
    <td>param</td>
    <td>${'${'}      param["name"]}
</td>
    <td>${param["name"]}    </td>
  </tr>
  <tr>
    <td>paramValues</td>
    <td>${'${'}      paramValues.multi[1]}
</td>
    <td>${paramValues.multi[1]}  -----${pageScope.num }  </td>
  </tr>
</table>
</body>
</html>

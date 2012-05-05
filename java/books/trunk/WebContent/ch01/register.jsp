<%@ page contentType="text/html;charSet=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鐢ㄦ埛鍚�/title>
<script language="javascript" type="">
	function RegsiterSubmit(){
		with(document.Regsiter){
			var user=document.Regsiter.loginName.value;
			var pass=document.Regsiter.password.value;
			if(user==null||user==""){
				alert("璇峰～鍐欑敤鎴峰悕");
				}
				else if(pass==null||pass==""){
					alert("璇峰～鍐欏瘑鐮�);
					}
				else document.Regsiter.submit();
			}
		}
</script>
</head>

<body>

<form method="POST" name="Regsiter" action="/books/ch01/validate.jsp">
  <p align="left">
  鐢ㄦ埛鍚�<input type="text" name="loginName" size="20"></p>
  <p align="left">
  瀵�nbsp; 鐮�<input type="password" name="password" size="20"></p>
  <p align="left">
  <input type="button" value="鎻愪氦" name="B1" onclick="RegsiterSubmit()">
  <input type="reset" value="閲嶇疆" name="B2"></p>
</form>

</body>

</html>

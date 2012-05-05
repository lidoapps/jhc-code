<%@ page contentType="text/html;charSet=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户名</title>
<script language="javascript" type="">
	function RegsiterSubmit(){
		with(document.Regsiter){
			var user=document.Regsiter.loginName.value;
			var pass=document.Regsiter.password.value;
			if(user==null||user==""){
				alert("请填写用户名");
				}
				else if(pass==null||pass==""){
					alert("请填写密码");
					}
				else document.Regsiter.submit();
			}
		}
</script>
</head> 

<body>

<form method="POST" name="Regsiter" action="/books/servlet/authen">
  <p align="left">
  用户名:<input type="text" name="loginName" size="20"></p>
  <p align="left">
  密&nbsp; 码:<input type="password" name="password" size="20"></p>
  <p align="left">
  <input type="button" value="提交" name="B1" onclick="RegsiterSubmit()">
  <input type="reset" value="重置" name="B2"></p>
</form>

</body>

</html>

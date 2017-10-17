<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body>
  ${msg }
		<form action="${pageContext.request.contextPath }/loginServlet"method="post" >
			账号:<input type="text" name="username"></br> 	
			密码:<input type="password" name="password"></br>
			    <input type="checkbox"  name="autologin">自动登录(7天内有效)</br>
			    <input type="submit" value="登录"></br>
		</form>	
</body>
</html>

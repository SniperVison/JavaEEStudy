<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <!--以后在JSP页面中路径一律用${pageContext.request.contextPath}+"/........."表示  -->
	<form action="${pageContext.request.contextPath} }/success.jsp" method="post">
		账号：<input type="text" name="username"><br /> 密码：<input type="password" name=pwd><br />
		<input type="submit" value="登录"><br />
	</form>
	<%
		
		response.setHeader("refresh","3;url="+request.getContextPath()+"/login.jsp");
		
	%>
</body>
</html>
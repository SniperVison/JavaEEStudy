<%@page import="com.vison.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student stu = new Student();
		stu.setName("vison");
		request.setAttribute("s",stu);//设置域对象,将stu对象放进request域对象中传递
		//session.setAttribute("s",stu);
		request.getRequestDispatcher("/2.jsp").forward(request, response);
	%>

</body>
</html>
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
		//Student stu = (Student) request.getAttribute("s");
		//out.print(stu + "<br/>");
		//out.print(2+3);
	%>
	<%-- <%=2+3 %> --%>
	
   <!--${s}==request.getAttribute("s"),同时${s}==session.getAttribute("s) ,所以总的来的说就是${s}==pageContext.findAttribute("s") -->
	<!--${s }EL表达式  -->
	
	
	<!--点（.）运算符相当于调了getter方法，点后面跟的是属性名  -->
	<!--${s.name }它的容错性很强 -->
	
	<!--方式一  -->
	${s.city.address }<!--属性导航  ,非常实用-->
	<!--方式二     点（.）能做到的，括号一定能做好；但是括号能做到的，点不一定能做到，换句说就是括号的权限比点（.）要大-->
	${s.city["address"] }
	
</body>
</html>
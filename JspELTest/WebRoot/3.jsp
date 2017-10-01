<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		request.setAttribute("list", list);
	%>
	${list[2] }
	<!--此处即取出“ccc”  -->
	<%
		Map<String, String> map = new HashMap<>();
		map.put("a", "aaaaa");
		map.put("b", "bbbbb");
		map.put("c", "ccccc");
		request.setAttribute("m", map);
	%>
	<!--方法一  -->
	<%-- 	${m["b"] } --%>
	<!--方法二  -->
	${m.c }


</body>
</html>
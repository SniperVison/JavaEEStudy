<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--此处为导入JSTL核心jar包，同时使用prefix起别名 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'index.jsp' starting page</title>
</head>

<body>

	<%-- <!--通用标签 set out remove ，这三个不常用  -->
	<!--声明一个变量num，值为10，scope=“session”表示变量的作用域为session作用域-->
	<c:set var="num" value="10" scope="session"></c:set>
	<!--输出num的值  -->
	输出变量:
	<!--方式一  -->
	<c:out value="${num }"></c:out>
	<!--方式二  -->
		${num }

	<!--移除num的值  -->
	<c:remove var="num" scope="session" />
	<!--default为设置默认值  -->
	输出变量:
		<c:out value="${num }" default="aaa"></c:out>
 --%>


	<%--
	<!--条件标签 if choose  -->

	<!--没有else标签，只有if标签  ,数值一定要放在“${}”里面才可以-->
	<c:if test="${5>3 }">
	     kkkkkkkk
	</c:if>

 
 <!--choose标签与foreach标签一起使用的时候会报错，不知道为何  -->
 	<!--choose标签   otherwise这个就类似于Java里面switch判断中的default的意思  -->
	<c:set var="num" value="${5}"></c:set>
	<c:choose>
		<c:when test="${num==1 }">aaa</c:when>
		<c:when test="${num==2 }">bbb</c:when>
		<c:when test="${num==3 }">ccc</c:when>
		<c:otherwise>ddd</c:otherwise>
	</c:choose> 
	--%>

	<!--迭代标签 foreach  -->
	<%-- 	<!--这里的意思就是for(int i=1;i<=10;i++) ,貌似只有递增功能 -->
	<c:forEach var="i" begin="1" end="10" step="1">
	${i }<br />
	</c:forEach>

 --%>
	<%--  <!--这里的forEach标签是用来迭代list集合的  -->
 <%
  List list=new ArrayList();
  list.add("aaa");
  list.add("bbb");
  list.add("ccc");
  request.setAttribute("list", list);
  %>
  <c:forEach items="${list }" var="l">
  ${l }</c:forEach>
 --%>

	<%
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		request.setAttribute("list", list);
	%>
	<table border="1">
		<tr>
			<th>数据</th>
			<th>索引</th>
			<th>计数</th>
			<th>第一个</th>
			<th>最后一个</th>
		</tr>
		<!--varStatus就是一个对象，它是用Map实现的，就是相当于map.put(key,value)  -->
		<c:forEach items="${list }" var="l" varStatus="vs">
			<tr ${vs.count%2==0 ? "style='background-color:red'":"style='baakground-color:black'"}>
				<td>${l }</td>
				<td>${vs.index }</td>
				<td>${vs.count }</td>
				<td>${vs.first }</td>
				<td>${vs.last }</td>

			</tr>
		</c:forEach>
	</table>



</body>
</html>

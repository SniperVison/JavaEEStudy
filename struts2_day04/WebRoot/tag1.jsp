<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ------------------------遍历标签iterator----------------- ----><hr>
<!--第一种遍历方式  -->
<s:iterator value="#list" >
  <s:property/></br><!--默认取栈顶  -->
</s:iterator>

<!-- --------------------------------------------------------- --><hr>
<!--第二种遍历方式  -->
<s:iterator value="#list" var="name" >
  <s:property value="name"/></br><!--默认取栈顶  -->
</s:iterator>

<!-- --------------------------------------------------------- --><hr>
<!--使用iterator遍历数数  --> 
<s:iterator begin="1" end="100" step="1">
  <s:property/>|
</s:iterator>


<!-- ------------------------------if else elseif-------------------------------  --><hr>
	<s:if test="#list.size()==4">
     list长度为4
  </s:if>
  
	<s:elseif test="#list.size()==3">
  list长度为3
  </s:elseif>
  
	<s:else>
  list not 3 not 4!
  </s:else>
  
  
  <!-- ------------------------------property 配合Ognl表达式页面取值-------------------------------  --><hr>
  <s:property value="#list.size()"/><!--只要是Ognl表达式，都是可以运行的  -->
  <s:property value="#session.user.name"/><!--例子  -->
</body>
</html>
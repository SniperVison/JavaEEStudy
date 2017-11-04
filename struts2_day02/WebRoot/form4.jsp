<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="${pageContext.request.contextPath }/param/ParamDemo4Action" method="post">
     list1:<input type="text" name ="list" /></br>
     <!--list[5]是指将这个元素放进list中的第六个位置，其他位置补null值  -->
     list2: <input type="text" name ="list[5]" /></br>  
     
     map:<input type="text" name ="map['姓名']" /></br>
         <input type="submit" value="提交"/>
  </form>
</body>
</html>
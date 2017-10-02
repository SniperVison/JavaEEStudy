<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 正则表达式校验密码
1、密码必须由数字、字符、特殊字符三种中的两种组成；
2、密码长度不能少于8个字符；
满足以上两点，应该怎么实现？
(?!^\\d+$)不能全是数字
(?!^[a-zA-Z]+$)不能全是字母
(?!^[_#@]+$)不能全是符号（这里只列出了部分符号，可自己增加，有的符号可能需要转义）
.{8,}长度不能少于8位
合起来就是
(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,} -->
账户：必须输入，且3-8位的字母组成<br/>
密码：必须输入，3-8的数字组成<br/>
确认密码：必须输入，且和密码保持一致<br/>
邮箱：必须输入，且要符合邮箱的格式<br/>
生日，必须输入，符合yyyy-MM-dd的格式<br/>


<form action="${pageContext.request.contextPath }/registerServlet" method="post">
       账户:<input type="text" name="username" value="${userForm.username }"/>${userForm.msg.username }${error }<br>
      密码:<input type="password" name="password" value="${userForm.password }"/>${userForm.msg.password }<br>
      确认密码:<input type="password" name="repassword"/>${userForm.msg.repassword }<br>
      邮箱:<input type="text" name="email" value="${userForm.email }"/>${userForm.msg.email }<br>
      出生日期:<input type="text" name="birthday" value="${userForm.birthday }"/>${userForm.msg.birthday }<br>
   <input type="submit" value="注册"/>
</form>

</body>
</html>
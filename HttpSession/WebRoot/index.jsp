<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
function changeCode()
{
//得到图片元素
var img=document.getElementsByTagName("img")[0];
//img.setAttribute("src","HttpServletResponse/demo3");//XML Dom语法
img.src="/HttpServletResponse/demo3?time="+new Date().getTime();
}
</script>
<head>

</head>

<body>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null)
{
out.print(msg);
}
 %>
<form action="/HttpSession/doLogin" method="post">
		账户： <input type="text" name='username' /> <br> 
		密码： <input type="password" name="pwd" /> <br>
		验证码: <input type="text" name="code" />
		 <img src="/HttpSession/codeServlet" onclick="changeCode()"/><a href="javascript:changeCode()">看不清楚换一张</a><br> 
		<input type="submit" value="登录" /> <br>
</body>
</html>

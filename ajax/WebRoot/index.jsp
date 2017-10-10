<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript">
	window.onload=function loadAjax() {
		//获取XMLHttpRequest对象
		var xmlhttp;
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else { // code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	
	xmlhttp.onreadystatechange = function() {
	//处理响应结果以及查看服务器响应状态
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		  alert(xmlhttp.responseText);
		}
	}
	//建立一个连接
	xmlhttp.open("GET","${pageContext.request.contextPath}/ajaxServletDemo1",true);
	//发送请求
	xmlhttp.send();
	}
</script>

</head>

<body>

</body>
</html>

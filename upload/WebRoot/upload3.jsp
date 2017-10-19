<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
    function addFile() {
		var div1 = document.getElementById("div1");
		div1.innerHTML += "<div><input type='file' name='upload'><input type='button' value='删除' onclick='deleteFile(this)'></div>";
	}
	function deleteFile(input) {
	//使用input对象的父节点的父节点（即爷爷节点）删除input对象的父节点
		input.parentNode.parentNode.removeChild(input.parentNode);
	}
</script>

</head>
<body>
<!--动态添加上传按钮上传多个文件  -->

<form enctype="multipart/form-data" action="${pageContext.request.contextPath }/uploadServlet2" method="post">
      账号:<input type="text" name="username"><br/>
		<div id="div1">
			<div>
				<input type="file" name="upload"><input type="button" value="添加" onclick="addFile()" /><br />
			</div>
		</div>
		<input type="submit" value="上传" ><br/>

  </form>
</body>
</html>
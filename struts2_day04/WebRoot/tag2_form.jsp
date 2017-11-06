<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!--struts2表单标签  -->
    <!--好处1:内置了一套样式，但用处不大  -->
    <!--好处2:自动回显，根据栈中的属性  -->
    <!--theme:指定表单的主题   
      xhtml:默认
      simple:没有主题    
        -->
    <s:form action="FormTagAction2" namespace="/" theme="xhtml">
      <s:textfield name="name" label="账号"></s:textfield>
      <s:password name="password" label="密码"></s:password>
     
     <!--单选框  -->
      <s:radio list="{'男','女'}" name="gender" label="性别"></s:radio>
      <s:radio list="#{1:'男',0:'女' }" name="gender" label="性别" ></s:radio><!--使用map,键值对(1和0要在键的前面)  -->
     
     <!--复选框  -->
     <s:checkboxlist list="#{3:'吃鸡',2:'大保健',1:'洗脚按摩',0:'打撸' }" name="hobbys" label="爱好"></s:checkboxlist>
     <!--选择框  -->
     <s:select list="#{0:'大专',1:'本科',2:'硕士',3:'博士' }" name="edu" label="学历"></s:select>
     <s:select list="#{0:'大专',1:'本科',2:'硕士',3:'博士' }" headerKey="" headerValue="---请选择---" name="edu" label="学历"></s:select> 
     
     <!--上传文件  -->
     <s:file name ="photo" label="近照:"></s:file>
     
     
     <!--文本域  -->
     <s:textarea name="desc" label="个人简介:"></s:textarea>
     
     <!--提交  -->
      <s:submit value="提交"></s:submit>
    </s:form>
    
    <!--非表单标签  -->
    <s:actionerror/>
</body>
</html>
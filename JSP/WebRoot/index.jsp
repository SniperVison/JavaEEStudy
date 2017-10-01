<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- JSP==HTML+JAVA -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
   <%
   
   Date date=new Date();
 out.write(date.toLocaleString());

  
    %>
  </body>
</html>

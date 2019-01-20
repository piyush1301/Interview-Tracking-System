<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@page import="java.util.Date"%>
<%@page import="com.wipro.its.dao.xyzDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String str=request.getParameter("value");
xyzDAOImpl dao=new xyzDAOImpl();
String d=dao.getTechnicalDate(str); 
System.out.println("We are Ajax");
System.out.println(d);
out.println(d);
%> 
</body>
</html>
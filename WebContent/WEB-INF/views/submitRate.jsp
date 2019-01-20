<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <a href="goToHR.html">Home</a>		
 <a href="logout.html">Logout</a>
<form:form action="subrathr.html" method="get">
<table>
<tr> 
<td>
Interview Id:
</td>
<td><form:input path="interviewID"/></td>
</tr>

<tr>
<td> <input type="submit" value="submit"></td></tr>
</table>
</form:form>
</body>
</html>
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
 <a href="goToAdmin.html">Home</a>		
 <a href="logout.html">Logout</a>
<form:form action="techScheduled.html" method="get">
<table>
<tr>
<td>
<form:label path="candidateID">candidateID:</form:label></td>
<td><form:input path="candidateID"/></td></tr>
<tr>
<td>
<form:label path="Subject">Subject</form:label>
<form:input path="Subject"/></td>
</tr>
<tr><td>
<form:label path="techID">techID</form:label></td>
<td><form:input path="techID"/></td></tr>
<tr><td><form:label path="interviewDate">interviewDate</form:label></td>
<td><form:input path="interviewDate"/></td></tr>
<tr><td>
<form:label path="interviewTime">interviewTime</form:label></td>
<td><form:input path="interviewTime"/></td></tr>
<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>	
</table>
</form:form>
</body>
</html>
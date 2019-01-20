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
<form:form name="f1" action="ratehr.html" method="get">
<table>

<tr>
<td><form:label path="hrPanelBean.empHRID">employee id:</form:label></td>
<td><form:input path="hrPanelBean.empHRID" value="${bean.hrPanelBean.empHRID}" readonly="true"/></td>
</tr>
<tr>

<td><form:label path="empHRRating">rating:</form:label></td>
<td><form:input path="empHRRating" value="${bean.empHRRating}"/></td>
<%-- <form:hidden path="hrPanelBean.empHRID" value="${bean.hrPanelBean.empHRID}"></form:hidden> --%>
</tr>
<tr><td><input type="submit" value="submit"></td></tr> 
</table>
</form:form>
</body>
</html>
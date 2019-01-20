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
 <a href="goToTech.html">Home</a>		
 <a href="logout.html">Logout</a>
<form:form name="f1" action="ratetech.html" method="get">
<table>

<tr>
<td><form:label path="techPanelBean.techID">employee id:</form:label></td>
<td><form:input path="techPanelBean.techID" value="${bean.techPanelBean.techID}" readonly="true"/></td>
</tr>
<tr>
<td><form:label path="techRating">rating:</form:label></td>
<td><form:input path="techRating" value="${bean.techRating}"/></td>
</tr>
<tr><td><input type="submit" value="submit"></td></tr> 
</table>
<span style="color: red;"><c:out value="${msg}"></c:out></span>
</form:form>
</body>
</html>
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
<form:form action="subrattech.html" method="get">
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
<h1>Interview Details</h1>
<table>
<c:if test="${!empty bean}">
<tr><th>Interview ID</th>
<th>Candidate ID</th>
<th>Candidate Name</th></tr>

<c:forEach items="${bean}" var="bean">
<tr>
				<td><c:out value="${bean.interviewID}"/></td>
				<td><c:out value="${bean.candidateBean.candidateID}"/></td>
			<td><c:out value="${bean.candidateBean.profile.firstName}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</table>
</form:form>
</body>
</html>

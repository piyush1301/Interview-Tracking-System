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
<table>
				
				<tr>
					<th>Candidate Id</th>
					
					<th>Skill</th>
					<th>Experience</th>
					<th>Qualification</th>
					<th>Designation</th>
					<th>Notice Period</th>
					<th>Current Working Location</th>
 					</tr>
 					<c:forEach items="${hrdet}" var="details">
				<tr>
					<td><c:out value="${details.candidateID}"/></td>
					<td><c:out value="${details.primarySkills}"/></td>
					<td><c:out value="${details.experience}"/></td>
					<td><c:out value="${details.qualification}"/></td>
					<td><c:out value="${details.designation}"/></td>
					<td><c:out value="${details.noticePeriod}"/></td>
					<td><c:out value="${details.location}"/></td>
				</tr>
				</c:forEach>
			</table>
</body>
</html>
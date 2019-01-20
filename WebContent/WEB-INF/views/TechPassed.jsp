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
			<table>
					<tr>
						<td>Interview ID</td>
						<td>${ID.interviewID}</td>
					</tr>
					
					<tr>
						<td>Candidate ID</td>
						<td>${ID.candidateBean.candidateID}</td>
					</tr>
					
					<tr>
						<td>Technical Interviewer ID</td>
						<td>${ID.techPanelBean.techID}</td>
					</tr>
					
					<tr>
						<td>Technical Interview Date</td>
						<td>${ID.interviewDate}</td>
					</tr>
					
					<tr>
						<td>Technical Interview Rating</td>
						<td>${ID.techRating}</td>
					</tr>
					
					<tr>
						<td>The Candidate cleared the technical interview</td>
						<td>The HR interview of the candidate is not scheduled</td>
					</tr>
			</table>
</body>
</html>
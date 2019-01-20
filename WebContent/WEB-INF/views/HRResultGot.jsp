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

		<a href="goToAdmin.html">HOME/</a>
			
 <a href="logout.html">Logout</a>
			<table>
				<tr>
					<td>Interview ID</td>
					<td>${Bean.interviewID}</td>
				</tr>
				
				<tr>
					<td>HR Rating</td>
					<td>${Bean.empHRRating}</td>
				</tr>
			</table>
			
			<form:form commandName="takeResultDecision" method="POST" action="Decided.html">
				<table>
					<tr>
						<td>Result</td>
						<td>
						<form:select path="result">
							<form:option value="PASS" label="PASS"/>
							<form:option value="FAIL" label="FAIL"/>
						</form:select>
						</td>		
					</tr>
				</table>
				<form:hidden path="interviewID" value="${Bean.interviewID}"/>
				<input type="submit" value="Submit">
			</form:form>
</body>
</html>
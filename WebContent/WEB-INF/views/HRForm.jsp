<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> <a href="goToHR.html">Home</a>		
 <a href="logout.html">Logout</a>
		<h1>The respective candidate has cleared the technical interview</h1>
		<h1>Want to book the candidate for HR interview?</h1>
		
		<table>
		
		<tr>
			<td>
				<form action="HrInterviewStart.html" method="GET">
					<input type="submit" value="Yes">
				</form>
		</td>
		<td>
				<form action="HrInterviewStop.html" method="GET">
					<input type="submit" value="No">
				</form>
		</td>
		</tr>
		</table>
</body>
</html>
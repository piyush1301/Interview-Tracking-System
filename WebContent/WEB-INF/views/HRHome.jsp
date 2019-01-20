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
<body><%
try
{
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader("Expires",0);
	if(session.getAttribute("SessionBegin")==null)
			{
		response.sendRedirect("index.jsp");
			}
	else
	{
		//session.setAttribute("SessionBegin",null);
	}
	
}
catch(Exception ex)
{
	response.sendRedirect("index.jsp");
}

%>
 <a href="goToHR.html">Home</a>		
 <a href="logout.html">Logout</a>

				<!-- <tr><td><a href="logout.html"><u>Logout</u></a></td></tr><br> -->
<h1>welcome hr!!</h1>

<h2><a href="viewCandidateHr.html">View candidates</a></h2>
<h2><a href="submitRatingshr.html">submit ratings</a></h2>
<h2><a href="viewFinalResults.html">view final results</a></h2>
<tr><td><a href="changePassword.html"><u>Change Password</u></a></td></tr>
</body>
</html>
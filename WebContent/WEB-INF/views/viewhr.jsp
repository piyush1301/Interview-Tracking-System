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
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<style>
#ccc{
color:red;
}
</style>
 

<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
		<script>
		$(document).ready(function() {
			$(function() {
			$("#DateField").datepicker( { minDate: new Date(2000,1,1)});
			});
			});	
		</script>
<body>
 <a href="goToHR.html">Home</a>		
 <a href="logout.html">Logout</a>
 
<%--  <%
 
 String msg = (String)request.getAttribute("msg");%>
 --%> 
<form:form action="viewhrdet.html" method="get">



 <%-- <div style="color:red; font-size:15px; font-weight:bold;">
					<% 
						if(msg==null)
							msg="";
						
					%>
					
					<%=msg %>
				</div> --%>
<table>

<%-- 

		   <input type="text" value="" placeholder="Username" id="username"  name="userID"/>
    <input type="password" value="" placeholder="Password" id="password" name="password"/>
    <span style="color: red; font-style: italic;"><c:out value="${msg}"></c:out></span>
			<br><br>
			<input type="submit" value="Submit"/>
		</form>

 --%>




<tr> 
<td>
HR employee</td>
<td>
<form:select path="hrPanelBean.empHRID">
<form:option value="HR01" label="Rishi"></form:option>
<form:option value="HR02" label="Mohan"></form:option>

</form:select>
</td>
</tr>
<tr>
<td>Interview Date:</td>
<td><form:input path="empHRInterviewDate" id="DateField" readonly="true"/></td>
</tr>

<tr>
<td> <input type="submit" value="submit"></td></tr>

	

</table>
<span style="color: red;"><c:out value="${msg}"></c:out></span>
</form:form>
</body>
</html>

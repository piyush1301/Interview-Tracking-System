<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function checkPassword() {
		if (document.getElementById('password').value == document
				.getElementById('confirm_password').value) {
			document.getElementById('submit').disabled = false;
		} else {
			window.alert("password and confirm password do not match.Enter again.");
			document.getElementById('submit').disabled = true;

		}

	}
</script>

</head>
<body>
 <a href="index.jsp">Home</a>		
 <a href="logout.html">Logout</a>
<form:form action="confirmpwd.html" method="get">
<div style="color:red; font-size:15px;">
						<% 
							String msg = (String)request.getAttribute("msg"); 
							if(msg==null)
								msg="";
						%>
						<%=msg %>
			</div>
<table>
<tr>
					<td>New Password</td>
					<td><input type="password" name="password" id="password" /></td>
					</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="confirm_password"
						id="confirm_password" onblur='checkPassword()' /></td>
				</tr>
				<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Submit" />
				</tr>
			</table></form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Load jQuery from Google's CDN -->
    <!-- Load jQuery UI CSS  -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    
    <!-- Load jQuery JS -->
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <!-- Load jQuery UI Main JS  -->
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    
    <!-- Load SCRIPT.JS which will create datepicker for input field  -->
	  <script>
	  /*  jQuery ready function. Specify a function to execute when the DOM is fully loaded.  */
	  $(document).ready(
	    
	    /* This is the function that will get executed after the DOM is fully loaded */
	    function () {
	      $( "#datepicker" ).datepicker({
	        minDate:new Date()
	      	
	      });
	    }

	  );
	  
	  
	  
	  function CheckIT()
	  {
		  var a=formCheck.empHRInterviewDate.value;
		  var b=formCheck.empHRInterviewTime.value;
		  var  time=/1[0-7]{1}:[0-5]{1}[0-9]{1}/;
		  
		  if(a=="")
			  {
			  	alert("Please Provide The Interview Date");
			  	return false;
			  }
		  else if(b=="")
			  {
			  alert("Please Provide The Interview Time");
			  	return false;
			  }
		  
		  
		  else if(!time.test(b))
			  {
			  	alert("Please Provide The Interview Time in correct format(10:00-17:00)");
			  	return false;
			  }
		  
		  else 
		  {
			return true;  
		  }
	  }
	  </script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <a href="goToHR.html">Home</a>		
 <a href="logout.html">Logout</a>	
 	<h5>${msg}</h5>
			
				<form:form commandName="HRDetail" action="VerifyHR.html" method="POST" name="formCheck" onsubmit="return CheckIT()">
					<table>
						<tr>
							<td>HR Name</td>
							<td>
								<form:select path="hrPanelBean.empHRName">
									<form:option value="Rishi" label="Rishi"/>
									<form:option value="Mohan" label="Mohan"/>							
								</form:select>
							</td>
							</tr>
						
						<tr>
							<td>HR Interview Date</td>
							<td><form:input path="empHRInterviewDate" id="datepicker" value=""/></td>
							
						</tr>
						
						<tr>
							<td>HR Interview Time</td>
							<td><form:input path="empHRInterviewTime" value=""/></td>
						</tr>
						
						<form:hidden path="candidateBean.candidateID" value="${ID}"/>
					</table>
					<input type="submit" value="Check Avalibility">
				</form:form>
				
				<h5>Click on Check Avalibility to see whether the HR interviewer is avalibile on that date or not</h5>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="styles.css" rel="stylesheet" type="text/css" media="screen" />
<title> </title>
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
			$("#DateField").datepicker( { maxDate: new Date(1996,1,1)});
			});
			});	
		var request;  
		function sendInfo1(value)  
		{    
		var url="registerajax1.jsp?val="+value;
		if(window.XMLHttpRequest)
		{  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject)
		{  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send();  
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		  
		function getInfo()
		{  
		if(request.readyState==4)
		{  
		var val=request.responseText;  
		document.getElementById('sj1').innerHTML=val;  
		}  
		}
}
		
		function sendInfo2(value)  
		{    
		var url="registerajax2.jsp?val="+value;
		if(window.XMLHttpRequest)
		{  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject)
		{  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send();  
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		  
		function getInfo()
		{  
		if(request.readyState==4)
		{  
		var val=request.responseText;  
		document.getElementById('sj2').innerHTML=val;  
		}  
		}
}
		
		function sendInfo3(value)  
		{    
		var url="registerajax3.jsp?val="+value;
		if(window.XMLHttpRequest)
		{  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject)
		{  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send();  
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		  
		function getInfo()
		{  
		if(request.readyState==4)
		{  
		var val=request.responseText;  
		document.getElementById('sj3').innerHTML=val;  
		}  
		}
}
		
		
		function sendInfo4(value)  
		{    
		var url="registerajax4.jsp?val="+value;
		if(window.XMLHttpRequest)
		{  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject)
		{  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send();  
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		  
		function getInfo()
		{  
		if(request.readyState==4)
		{  
		var val=request.responseText;  
		document.getElementById('sj4').innerHTML=val;  
		}  
		}
}
		
		
	 function sendInfo6(value)  
		{    
		var url="registerajax6.jsp?val="+value;
		if(window.XMLHttpRequest)
		{  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject)
		{  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send();  
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		  
		function getInfo()
		{  
		if(request.readyState==4)
		{  
		var val=request.responseText;  
		document.getElementById('sj6').innerHTML=val;  
		}  
		}
}

		
		
	
		
		function sendInfo7(value)  
		{    
		var url="registerajax7.jsp?val="+value;
		if(window.XMLHttpRequest)
		{  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject)
		{  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send();  
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		  
		function getInfo()
		{  
		if(request.readyState==4)
		{  
		var val=request.responseText;  
		document.getElementById('sj7').innerHTML=val;  
		}  
		}
}
	

		function sendInfo8(value)  
		{    
		var url="registerajax7.jsp?val="+value;
		if(window.XMLHttpRequest)
		{  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject)
		{  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send();  
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		  
		function getInfo()
		{  
		if(request.readyState==4)
		{  
		var val=request.responseText;  
		document.getElementById('sj8').innerHTML=val;  
		}  
		}
}
	

		function sendInfo9(value)  
		{    
		var url="registerajax7.jsp?val="+value;
		if(window.XMLHttpRequest)
		{  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject)
		{  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send();  
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		  
		function getInfo()
		{  
		if(request.readyState==4)
		{  
		var val=request.responseText;  
		document.getElementById('sj9').innerHTML=val;  
		}  
		}
}
	

		function sendInfo10(value)  
		{    
		var url="registerajax7.jsp?val="+value;
		if(window.XMLHttpRequest)
		{  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject)
		{  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
		  
		try  
		{  
		request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send();  
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}  
		  
		function getInfo()
		{  
		if(request.readyState==4)
		{  
		var val=request.responseText;  
		document.getElementById('sj10').innerHTML=val;  
		}  
		}
}
	
		
		

</script>

</head>
<body>
<div id="content">
<div id="back">
<!-- header begins -->
<div id="header">
 <div id="menu1">
  <div id="menu">
		<ul>
			
			<li id="button2"><a href="goToAdmin.html" title="">Home</a></li>
			<li id="button3"><a href="gallery.jsp" title="">Gallery</a></li>
			<li id="button4"><a href="logout.html" title="">Logout</a></li>
			<li id="button5"><a href="contact.jsp" title="">Contact</a></li>
		</ul>
	</div>
 </div>
	<div id="logo">
		
		
	</div>
</div>
<!-- header ends -->
<!-- content begins -->
 <div id="main">
	<div id="right">
	<h2><b><center><font color="blue" size="6"><u>Welcome to XYZ Solutions!!</u></font></center></b></h2><br/></br><br/>
<h1><u><center><a href="login.html">Enter Details..</a></u></center></h1><br/></br><br/></br>
<form:form commandName="ProfileDetails" action="AddInProfile.html" method="POST">
				<table class="responstable" align="center">
					<tr>
					
					 <td><form:label path="firstName">First Name</form:label></td>
					<%--  <td><form:input path="address" onblur="sendInfo6(this.value)"/></td> --%>	
						<td><form:input path="firstName" onblur="sendInfo1(this.value)"/></td>
						<td><div id="sj1" style="color:red"></div> </td>
						 <td><form:errors path="firstName"  cssClass="error"/></td>
					</tr>
							
					
					
					<tr>
						<td><form:label path="lastName">Last Name</form:label></td>
						<td><form:input path="lastName" onblur="sendInfo5(this.value)"/></td>
						 <td><div id="sj5" style="color:red"></div> </td>
						 <td><form:errors path="lastName"  cssClass="error"/></td>
					</tr>
					
					
					
					
					<tr>
						<td><form:label path="dateOfBirth">Date Of Birth</form:label></td>
						<td><form:input path="dateOfBirth" id="DateField" readonly="true" onblur="sendInfo3(this.value)"/></td>
			        <td><div id="sj3" style="color:red"></div> </td> 
						 <td><form:errors path="dateOfBirth"   cssClass="error"/></td>
					</tr>			
					
					
					<tr>
						<td><form:label path="gender">Gender</form:label></td>
						<td>Male<form:radiobutton path="gender" value="Male" />
						<td>Female<form:radiobutton path="gender" value="Female" />
						 <td><form:errors path="gender"  cssClass="error"/></td>
					</tr>
					
					
					
					<tr>
						<td><form:label path="street">Street</form:label></td>
						
						<td><form:input path="street" onblur="sendInfo7(this.value)"/></td>
						 <td><div id="sj7" style="color:red"></div> </td>
						 <td><form:errors path="street"  cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><form:label path="location">Location</form:label></td>
						<td><form:input path="location" onblur="sendInfo8(this.value)"/></td>
						 <td><div id="sj8" style="color:red"></div> </td>
						 <td><form:errors path="location"  cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><form:label path="city">City</form:label></td>
						<td><form:input path="city" onblur="sendInfo9(this.value)"/></td>
						 <td><div id="sj9" style="color:red"></div> </td>
						 <td><form:errors path="city"  cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><form:label path="state">State</form:label></td>
						<td><form:input path="state" onblur="sendInfo10(this.value)"/></td>
						 <td><div id="sj10" style="color:red"></div> </td>
						 <td><form:errors path="state"  cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><form:label path="pincode">Pin Code</form:label></td>
						<td><form:input path="pincode" onblur="sendInfo6(this.value)"/></td>
			            <td><div id="sj6" style="color:red"></div> </td>
						 <td><form:errors path="pincode"  cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><form:label path="mobileNo">Mobile NO</form:label></td>
						<td><form:input path="mobileNo"  onblur="sendInfo4(this.value)"/></td>
			             <td><div id="sj4" style="color:red"></div> </td>
						 <td><form:errors path="mobileNo"  cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><form:label path="emailId">Email ID</form:label></td>
						<td><form:input path="emailId" onblur="sendInfo2(this.value)"/></td>
			        <td><div id="sj2" style="color:red"></div> </td> 
						 <td><form:errors path="emailId"  cssClass="error"/></td>
					</tr>
				</table><br><br>
				<pre>                     <input type="submit" value="Submit"/></pre>
			</form:form>
			</div>
	<div id="left">	
	<h3>FEATURES</h3>
			<ul>
			  <li><ul>
				 <li><a href="featureSchedule.jsp">Schedule Your Interview</a></li>
				  <li><a href="featureRatings.jsp">View Your Ratings</a></li>
				  <li><a href="featurePotential.jsp">Get to Know Your Potential</a></li>
				  <li><a href="featureSubject.jsp">Select Interview Subject</a></li>
				 
				  </ul>
			  </li>
			</ul>	
	<h3>Calendar</h3>
			<ul>
				<li id="calendar">			
				<div id="calendar1">
					<table id="calendar2" summary="Calendar">
						<caption>
						March 2016
						</caption>
						<thead>
							<tr>
								<th abbr="Monday" scope="col" title="Monday">M</th>
								<th abbr="Tuesday" scope="col" title="Tuesday">T</th>
								<th abbr="Wednesday" scope="col" title="Wednesday">W</th>
								<th abbr="Thursday" scope="col" title="Thursday">T</th>
								<th abbr="Friday" scope="col" title="Friday">F</th>
								<th abbr="Saturday" scope="col" title="Saturday">S</th>
								<th abbr="Sunday" scope="col" title="Sunday">S</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td abbr="Feb" colspan="3" id="prev"><a href="#">&laquo; Feb</a></td>
								<td class="pad">&nbsp;</td>
								<td abbr="Apr" colspan="3" id="next" class="pad"><a href="#">Apr &raquo;</a></td>
							</tr>
						</tfoot>
						<tbody>
							<tr>
								<td colspan="2" class="pad">&nbsp;</td>
								<td>1</td>
								<td>2</td>
								<td>3</td>
								<td id="now">4</td>
								<td>5</td>
							</tr>
							<tr>
								<td>6</td>
								<td>7</td>
								<td>8</td>
								<td>9</td>
								<td>10</td>
								<td>11</td>
								<td>12</td>
							</tr>
							<tr>
								<td>13</td>
								<td>14</td>
								<td>15</td>
								<td>16</td>
								<td>17</td>
								<td>18</td>
								<td>19</td>
							</tr>
							<tr>
								<td>20</td>
								<td>21</td>
								<td>22</td>
								<td>23</td>
								<td>24</td>
								<td>25</td>
								<td>26</td>
							</tr>
							<tr>
								<td>27</td>
								<td>28</td>
								<td>29</td>
								<td>30</td>
								<td>31</td>
								<td class="pad" colspan="2">&nbsp;</td>
							</tr>
						</tbody>
					</table>
				</div>
			</li>
		  </ul>
		  <h3>Our Website</h3>
			<p>We work for XYZ Solutions. <a href="#">More...</a></p>
			<br />
		  </div>
	

<!--content ends -->

<!--footer begins -->
	</div>

<div id="footer">
<p align="center"><B><I>Copyright @ 2014 Wipro Technologies.All Rights Reserved</p>
<p><a href="#">Privacy Policy</a> | <a href="#">Terms of Use</a> | <a href="http://validator.w3.org/check/referer" title="This page validates as XHTML 1.0 Transitional"><abbr title="eXtensible HyperText Markup Language">XHTML</abbr></a> | <a href="http://jigsaw.w3.org/css-validator/check/referer" title="This page validates as CSS"><abbr title="Cascading Style Sheets">CSS</abbr></a></p>
	</div>
</div>
</div>
<!-- footer ends-->

			
</body>
</html>
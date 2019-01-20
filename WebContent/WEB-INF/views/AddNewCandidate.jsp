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
<title>Candidate Personel Details</title>
<script>window.history.forward(1)</script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<style>
#ccc{
color:red;
}
</style>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<script>

var request;
function sendInfo1(value)  
{    
var url="registerajax10.jsp?val="+value;
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



function sendInfo2(value)  
{    
var url="registerajax9.jsp?val="+value;
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
document.getElementById('sj5').innerHTML=val;  
}  
}
}

function cho() 
{
		if(piy.experience.value=="")
		{
			alert("Please Enetr the Experience");
			return false;
		}
		else if(piy.experience.value>25)
		{
			alert("Experience Should be less than 25 years");
			return false;
		}
	
		else if(piy.noticePeriod.value=="")
		{
			alert("Please Enter the Notice Period");
			return false;
		}		
		else if(piy.noticePeriod.value>5)
		{
			alert("Notice Period should be less than 5 months");
			return false;
		}
		else
		{
			return true;	
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
<form:form name="piy" commandName="CandidateDetails" action="AddInCandidate.html" method="POST" onsubmit="return cho()">
				<table>
					<tr>
						<td><form:label path="primarySkills">Primary Skills</form:label></td>
						<td>
							<form:select path="primarySkills">
								
								<form:option value="Java" label="Java"/>
								<<form:option value="Python" label="Python"/>
								<form:option value="Android" label="Android"/>
							</form:select>
						</td>
						</tr>
					
					
					<tr>
						<td><form:label path="secondarySkills">Secondary Skills</form:label></td>
						<td>
							<form:select path="secondarySkills">
								<form:option value="OOPS Concept" label="OOPS Concept"/>
								<form:option value="SQL" label="SQL"/>
								
								<form:option value="Hibernate" label="Hibernate"/>
								<form:option value="Struts " label="Struts"/>
								
								
							</form:select>
							</td>
						
					</tr>
					
					
					
					
					<tr>
						<td><form:label path="experience">Experience</form:label></td>
						<td><form:input path="experience"  onblur="sendInfo2(this.value)" value=""/></td>
			             <td><div id="sj5" style="color:red"></div> </td>
						
					</tr>
					
					
					<tr>
						<td><form:label path="qualification">Qualification</form:label></td>
						<td>
							<form:select path="qualification">
								<form:option value="B.E." label="B.E."/>
								<form:option value="B.Tech" label="B.Tech"/>
								<form:option value="M.Tech" label="M.Tech"/>
								<form:option value="B.B.A." label="B.B.A."/>
								<form:option value="M.B.A." label="M.B.A."/>
							</form:select>
						</td>
						
					</tr>
						
					<tr>
						<td><form:label path="designation">Designation</form:label></td>
						<td><form:input path="designation"/></td>
						<td><form:errors path="designation"  cssClass="error"/></td>
					</tr>		
					
					
					
					
					
					
					<tr>
						<td><form:label path="noticePeriod">Notice Period</form:label></td>
						<td><form:input path="noticePeriod"  onblur="sendInfo1(this.value)" value=""/></td>
			             <td><div id="sj4" style="color:red"></div> </td>
						
					</tr>
					
					
					
					
					
					
					<tr>
					<td><form:label path="location">Location</form:label></td>
						
						<td><form:input path="location"/></td>
						<td><form:errors path="location"  cssClass="error"/></td>
					</tr>	
					
					<tr>
						<td><form:hidden path="shareDetails" value="0"/></td>
					</tr>	
							
				</table>
				<input type="submit" value="Submit"/>
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
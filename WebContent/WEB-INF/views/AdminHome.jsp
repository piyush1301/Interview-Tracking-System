<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script>        /*  tell chacha bout this */
window.history.forward(1);
</script>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="styles.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<%
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
<div id="content">
<div id="back">
<!-- header begins -->
<div id="header">
 <div id="menu1">
  <div id="menu">
		<ul>
			
			<li id="button2"><a href="goToAdmin.html" title="">Home</a></li>
			<li id="button3"><a href="gallery.jsp" title="">Gallery</a></li>
			<li id="button4"><a href="logout.html" title="">logout</a></li>
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
	<h2><b><center><font color="blue" size="6"><u>Welcome ADMIN!!</u></font></center></b></h2><br/>

			
		
<form:form action="logout.html" method="get">

				<tr><td><a href="logout.html"><u>Logout</u></a></td></tr><br><br><br>
				<tr><td><a href="AddCandidate.html"><u>Add Candidate</u></a></td></tr><br><br><br>
				<tr><td><a href="ViewCandidate.html"><u>View Candidate</u></a></td></tr><br><br><br>
				<tr><td><a href="ShareDetails.html"><u>ShareDetails</u></a></td></tr><br><br><br>
				<tr><td><a href="ViewRatings.html"><u>ViewInterviewRatings</u></a></td></tr><br><br><br>
				<tr><td><a href="TakeResult.html"><u>TakeResult</u></a></td></tr><br><br><br>
				<tr><td><a href="ShareResult.html"><u>ShareResult</u></a></td></tr>
				<tr><td><a href="changePassword.html"><u>Change Password</u></a></td></tr>
</form:form>
<%-- </div>
	<div id="left">	
	<h3>FEATURES</h3>
			<ul>
			  <li><ul>
				  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="styles.css" rel="stylesheet" type="text/css" media="screen" />
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
			<li id="button4"><a href="logout.html" title="">logout</a></li>
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
	<div id="right"> --%>
				<!-- <a href="goToAdmin.html">HOME</a> -->
				<h1>One Candidate added successfully</h1>
				<h1>The id of the candidate is "${ID}"</h1>
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
								<td id="now">3</td>
								<td>4</td>
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

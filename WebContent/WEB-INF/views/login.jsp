<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="styles.css" rel="stylesheet" type="text/css" media="screen" />
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<title>Elegant Login - Designscrazed</title>
<style>
body {
   /*  background: url('http://i.imgur.com/Eor57Ae.jpg') no-repeat fixed center center; */
    background-size: cover;
    font-family: Montserrat;
}

.logo {
    width: 213px;
    height: 36px;
    background: url('http://i.imgur.com/fd8Lcso.png') no-repeat;
    margin: 30px auto;
}

.login-block {
    width: 320px;
    padding: 20px;
    background: #fff;
    border-radius: 5px;
    border-top: 5px solid #ff656c;
    margin: 0 auto;
}

.login-block h1 {
    text-align: center;
    color: #000;
    font-size: 18px;
    text-transform: uppercase;
    margin-top: 0;
    margin-bottom: 20px;
}

.login-block input {
    width: 100%;
    height: 42px;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    font-size: 14px;
    font-family: Montserrat;
    padding: 0 20px 0 50px;
    outline: none;
}

.login-block input#username {
    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px top no-repeat;
    background-size: 16px 80px;
}

.login-block input#username:focus {
    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px bottom no-repeat;
    background-size: 16px 80px;
}

.login-block input#password {
    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px top no-repeat;
    background-size: 16px 80px;
}

.login-block input#password:focus {
    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px bottom no-repeat;
    background-size: 16px 80px;
}

.login-block input:active, .login-block input:focus {
    border: 1px solid #ff656c;
}

.login-block button {
    width: 100%;
    height: 40px;
    background: #ff656c;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #e15960;
    color: #fff;
    font-weight: bold;
    text-transform: uppercase;
    font-size: 14px;
    font-family: Montserrat;
    outline: none;
    cursor: pointer;
}

.login-block button:hover {
    background: #ff7b81;
}

</style>
</head>
<%
	String msg = (String)request.getAttribute("msg");
	%>
<body>
<div id="content">
<div id="back">
<!-- header begins -->
<div id="header">
 <div id="menu1">
  <div id="menu">
		<ul>
			
			<li id="button2"><a href="index.jsp" title="">Home</a></li>
			<li id="button3"><a href="gallery.jsp" title="">Gallery</a></li>
			<li id="button4"><a href="about.jsp" title="">About</a></li>
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
			<div class="logo"></div>
<div class="login-block">
<form action="userChk.html" method="GET">
		<%-- <form:form method="GET" action="userChk.html"> --%>
		<!-- <table> -->
		<h2><b><center><font color="blue" size="6">LOGIN!!</font></center></b></h2><br/>
		<%-- <tr>	<td><form:label path="userID">USER ID:</form:label></td>
				<td><form:input path="userID" /></td>
				</tr>
			<tr>	<td><form:label path="password">PASSWORD:</form:label></td>
				<td><form:input path="password" /></td>
				</tr>
				<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>	
		</table> --%>
		<%-- </form:form> --%>
		
		   <input type="text" value="" placeholder="Username" id="username"  name="userID"/>
    <input type="password" value="" placeholder="Password" id="password" name="password"/>
    <input type="submit" value="Submit"/>
    <div style="color:red; font-size:15px; font-weight:bold;">
					<% 
						if(msg==null)
							msg="";
						
					%>
					
					<%=msg %>
				</div>
				</form>
	</div>	
</div>
	<div id="left">	
	<h3>FEATURES</h3>
			<ul>
			  <li><ul>
				  <li><a href="#">Schedule Your Interview</a></li>
				  <li><a href="#">View Your Ratings</a></li>
				  <li><a href="#">Get to Know Your Potential</a></li>
				  <li><a href="#">Select Interview Subject</a></li>
				 
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

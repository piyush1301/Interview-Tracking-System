<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
String pin=request.getParameter("val");  
if(pin.equals(""))
	out.print("Enter Pin Code"); 

if(pin.length()!=6 && pin.length()>0)
	out.print("Pin Code Must Contain 6 Digits"); 
for(char c : pin.toCharArray()){
    if(Character.isDigit(c)){
    	continue;
    }
   	else
        out.print("Pin Code Contains Only Digits");
        break;
}
%> 
</body>
</html>
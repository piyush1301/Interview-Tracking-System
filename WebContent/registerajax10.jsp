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
	out.print("Enter Notice Period"); 

if(pin.length()<2 && pin.length()>0)
	out.print("Notice period Should be Less than 10 months"); 
for(char c : pin.toCharArray()){
    if(Character.isDigit(c)){
    	continue;
    }
   	else
        out.print("Notice Period Is the No Of Months");
        break;
}
%> 
</body>
</html>
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
	out.print("Enter Experience"); 

for(char c : pin.toCharArray()){
    if(Character.isDigit(c)){
    	continue;
    }
   	else
        out.print("Experience is Counted In No Of Years");
        break;
}

if(pin.length()>2 && pin.length()>0)
	out.print("Enter Valid Experience"); 

int k=Integer.parseInt(pin);

if(k>25)
	out.print("Experience should be less than 25"); 




%> 
</body>
</html>
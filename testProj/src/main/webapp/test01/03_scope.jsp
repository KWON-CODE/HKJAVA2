<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("age", 23);
		request.setAttribute("height", 170.6);
		
		int age = (int)request.getAttribute("age");
		double h =(double)request.getAttribute("height");
		double h2=h;
		
	%>
	나이:<%=age %><br>
	키: <%=h2%>
</body>
</html>
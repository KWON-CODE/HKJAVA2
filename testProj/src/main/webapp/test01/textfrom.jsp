<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%String result=request.getParameter("name"); %>
    
    <h1>name : <%=result %></h1>
    
    <%// http://localhost:8081/testProj/test01/textfrom.jsp?name=java %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>text form page</h1>
	입력한정보 <br>
	
</body>
</html>
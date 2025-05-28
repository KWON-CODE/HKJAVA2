<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <% // page buffer="1kb" autoFlush="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String start="[";
		String end= "]";

	%>
	<%@ include file= "date.jsp" %> 입니다<br>
	<%=jsp_var %><br>
	<%=name %>
</body>
</html>
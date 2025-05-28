<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>관심분야</h3>
	<%
		String[] interest=request.getParameterValues("cp");
		for(int i=0;i<interest.length-1;i++); {
	%> <b><%=interest[i] %></b>,
	<%} %>
	<b><%=interest[interest.length-1] %></b>
	<b><%=request.getParameter("m_state") %></b>
</body>
</html>
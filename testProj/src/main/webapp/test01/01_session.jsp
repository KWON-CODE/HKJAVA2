<%@page import="java.sql.Date"%>
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
	if (session.isNew()) {
		out.println("NEW<br>");
		out.println("Sessin ID :" +session.getId());	
		out.println("Create Time :" + new Date(session.getCreationTime()) +"<br>");
		out.println("Last Access Time" + new Date(session.getLastAccessedTime()) + "<br>");
		out.println("Max inactiove interval :" + session.getMaxInactiveInterval() + "<br>");
	}else {
		out.println("old");
	}
%>
</body>
</html>
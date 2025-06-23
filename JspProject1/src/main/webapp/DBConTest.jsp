<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*,javax.sql.*,javax.naming.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn=null;
try{
	Context ctx= new InitialContext();
	DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
	conn =ds.getConnection();
	//out.print("성공");
} catch (Exception e){
	e.printStackTrace();
	//out.print("연결실패");
}%>
</body>
</html>
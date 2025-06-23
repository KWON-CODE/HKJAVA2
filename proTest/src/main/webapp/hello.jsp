<%-- <%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%> --%>
<%@page import="java.sql.*,javax.sql.*,javax.naming.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>오라클 연결</h1>
<%
Connection con=null;
try{
	Context ctx= new InitialContext();
	DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
	con=ds.getConnection();
	out.print("성공");
} catch (Exception e){
	e.printStackTrace();
}%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.naming.*" %>
    <%@ page import="javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello
	
	<%
	Connection conn = null;
	try{
	Context initContext = new InitialContext();
	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
	conn = ds.getConnection();
	out.print("성공");
	} catch(Exception e){
		e.printStackTrace();
	} finally{
		conn.close();
	}
	
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page session="true" %>
    
    <%
    	String userID="jsp";
    	String userID2="oracle";
    	
    	String userID3=(String)session.getAttribute("USERID");
    	
    	session.setAttribute("userID", userID);
    	session.setAttribute("userID2", userID2);

    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8081/testProj/src/main/webapp/jsp01/login3.jsp" method="post" name="frmLogin"> 
		아이디:<input type="text" name="user_id"><br>
		비밀번호:<input type="password" name="user_pw"> <br>
		<input type="submit" value="로그인">
		<input type="reset" value="초기화">	
	</form>
</body>
</html>
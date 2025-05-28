<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memberList" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="memberMap" class="java.util.HashMap"></jsp:useBean>

<%
	memberMap.put("id", "java");
	memberMap.put("pwd", "java");
	memberMap.put("name", "java");
	memberMap.put("email", "java");

	memberBean m1 = new MemberBean("java2", "java2", "java2", "java2@kr");
	memberBean m2 = new MemberBean("java3", "java3", "java3", "java3@kr");

	memberList.add(m1);
	memberList.add(m2);
	
	memberMap.put("memberList",memberList);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="text-align: center;">
	<tr align="center" bgcolor="#99ccff">
				<td width="20%"><b>아이디</b></td>
				<td width="20%"><b>비밀번호</b></td>
				<td width="20%"><b>이름</b></td>
				<td width="20%"><b>이메일</b></td>
	</tr>
		<tr style="text-align: center;">
			<td>${memberMap.id}</td>
			<td>${memberMap.pwd}</td>
			<td>${memberMap.name}</td>
			<td>${memberMap.email}</td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,sec01.ex01.*"
    isELIgnored="false"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <% request.setCharacterEncoding("UTF-8"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
<style type="text/css">
	.cls
</style>
</head>
<body>
<table>
	<c:choose>
	<c:when test="${memberList==null}">
	<tr>
		<td colspan=5>
			<b>등록된 회원이 없습니다</b>
		</td>
	</tr>
	</c:when>
	<c:when test="${memberList!=null}">
		<c:forEach var="mem" items="${memberList}">
			<tr>
			<td>${mem.id}</td>
			<td>${mem.pwd}</td>
			<td>${mem.name }</td>
			<td>${mem.email }</td>
			<td>${mem.joinDate }</td>
			</tr>
		</c:forEach>
	</c:when>
	</c:choose>
	</table>
	<a href="#">
	<p class="cls2">회원가입하기</p>
	</a>
</body>
</html>
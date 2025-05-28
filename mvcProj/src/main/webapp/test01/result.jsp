<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="file1" value="${param.param1}"></c:set>
<c:set var="file2" value="${param.param2}"></c:set>

</head>
<body>
	파라미터1: <c:out value="${file1}"></c:out>
	파라미터2: <c:out value="${file2}"></c:out>
<c:if test="${not empty file1}">
	<img alt="" src="${contextPath}/download.do?fileName${file1}" width="300" height="200">
	</c:if>
	<c:if test="${not empty file2}">
	<img alt="" src="${contextPath}/download.do?fileName${file2}" width="300" height="200">
</c:if>
파일 내려 받기: <br>
<a href="${contextPath}/download.do?fileName=${file2}"> 파일내려받기</a>
</body>
</html>
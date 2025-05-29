<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%-- 날짜 포맷팅을 위해 fmt 태그 라이브러리 추가 --%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
    table { width: 80%; border-collapse: collapse; margin: 20px auto; }
    th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
    th { background-color: #f2f2f2; }
    .button-container { text-align: center; margin-top: 20px; }
    .button-container a { margin: 0 10px; padding: 8px 15px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 4px; }
    .button-container a.delete { background-color: #f44336; }
</style>
</head>
<body>
    <h2 style="text-align:center;">회원 정보</h2>
    <table>
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        <c:choose>
            <c:when test="${empty membersList}">
                <tr>
                    <td colspan="7">등록된 회원이 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="member" items="${membersList}">
                    <tr>
                        <td>${member.id}</td>
                        <td>${member.pwd}</td>
                        <td>${member.name}</td>
                        <td>${member.email}</td>
                        <td>
                            <%-- Date 객체를 yyyy-MM-dd 형식으로 포맷팅하여 표시 --%>
                            <fmt:formatDate value="${member.joinDate}" pattern="yyyy-MM-dd" />
                        </td>
                        <td><a href="${pageContext.request.contextPath}/member/modMemberForm.do?id=${member.id}">수정</a></td>
                        <td><a href="${pageContext.request.contextPath}/member/delMember.do?id=${member.id}" onclick="return confirm('정말로 삭제하시겠습니까?');" class="delete">삭제</a></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
    <div class="button-container">
        <a href="${pageContext.request.contextPath}/member/memberForm.do">회원 가입</a>
    </div>
</body>
</html>
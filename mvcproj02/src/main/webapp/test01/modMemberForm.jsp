<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%-- 추가 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
    form { width: 50%; margin: 20px auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
    label { display: inline-block; width: 100px; margin-bottom: 10px; }
    input[type="text"], input[type="password"], input[type="email"] { width: calc(100% - 120px); padding: 8px; margin-bottom: 10px; border: 1px solid #ddd; border-radius: 3px; }
    input[type="submit"] { padding: 10px 20px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
    input[type="submit"]:hover { background-color: #0056b3; }
    .button-container { text-align: center; margin-top: 10px; }
</style>
</head>
<body>
    <h2 style="text-align:center;">회원 정보 수정</h2>
    <c:if test="${not empty memInfo}">
        <form method="post" action="${pageContext.request.contextPath}/member/updateMember.do">
            <input type="hidden" name="id" value="${memInfo.id}">
            <div>
                <label for="id_display">아이디:</label>
                <input type="text" id="id_display" name="id_display" value="${memInfo.id}" readonly style="background-color:#eee;">
            </div>
            <div>
                <label for="pwd">새 비밀번호:</label>
                <input type="password" id="pwd" name="pwd" placeholder="변경 시에만 입력">
            </div>
            <div>
                <label for="name">이름:</label>
                <input type="text" id="name" name="name" value="${memInfo.name}" required>
            </div>
            <div>
                <label for="email">이메일:</label>
                <input type="email" id="email" name="email" value="${memInfo.email}" required>
            </div>
            <div>
                <label>가입일:</label>
                <span><fmt:formatDate value="${memInfo.joinDate}" pattern="yyyy-MM-dd" /></span>
            </div>
            <div class="button-container">
                <input type="submit" value="수정하기">
            </div>
        </form>
    </c:if>
    <c:if test="${empty memInfo}">
        <p style="text-align:center; color:red;">수정할 회원 정보를 찾을 수 없습니다.</p>
    </c:if>
</body>
</html>
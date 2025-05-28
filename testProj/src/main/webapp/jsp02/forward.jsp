<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 정보 확인</title>
<style>
    body { font-family: sans-serif; margin: 20px; }
    .container {
        width: 500px; /* 테이블 너비에 맞게 조정 */
        margin: 20px auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    h2 { text-align: center; }
    a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #007bff;
    }
    a:hover { text-decoration: underline; }
</style>
</head>
<body>
    <div class="container">
        <h2>가입 정보 확인 (/jsp02/forward.jsp)</h2>
        <%-- request 객체에 저장된 속성들을 EL(Expression Language)로 가져와서 표시 --%>
        <table>
            <tr>
                <th>항목</th>
                <th>정보</th>
            </tr>
            <tr>
                <td>아이디</td>
                <td>${requestScope.id}</td> <%-- 또는 간단히 ${id} --%>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>${requestScope.pwd}</td> <%-- 또는 간단히 ${pwd} --%>
            </tr>
            <tr>
                <td>이름</td>
                <td>${requestScope.name}</td> <%-- 또는 간단히 ${name} --%>
            </tr>
            <tr>
                <td>이메일</td>
                <td>${requestScope.email}</td> <%-- 또는 간단히 ${email} --%>
            </tr>
            <tr>
                <td>주소</td>
                <td>${requestScope.address}</td> <%-- 또는 간단히 ${address} --%>
            </tr>
        </table>
        <br>
        <div style="text-align: center;">
             <a href="${pageContext.request.contextPath}/jsp02/memberForm.jsp">돌아가기</a>
        </div>
    </div>
</body>
</html>
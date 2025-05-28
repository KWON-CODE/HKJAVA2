<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<style>
    body { font-family: sans-serif; margin: 20px; }
    .container {
        width: 300px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    label { display: inline-block; width: 80px; margin-bottom: 10px; }
    input[type="text"], input[type="password"], input[type="email"] {
        width: calc(100% - 90px);
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ddd;
        border-radius: 3px;
    }
    input[type="submit"], input[type="reset"] {
        padding: 10px 15px;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        margin-right: 10px;
    }
    input[type="submit"] { background-color: #4CAF50; color: white; }
    input[type="reset"] { background-color: #f44336; color: white; }
    h2 { text-align: center; }
</style>
</head>
<body>
    <div class="container">
        <h2>회원 가입창</h2>
        <%-- 
            action 속성: 폼 데이터를 전송할 URL (서블릿 매핑 경로)
            method 속성: HTTP 전송 방식 (GET 또는 POST)
        --%>
        <form action="${pageContext.request.contextPath}/memberServlet2" method="post">
            <div>
                <label for="id">아이디:</label>
                <input type="text" id="id" name="id" value="cha" required>
            </div>
            <div>
                <label for="pwd">비밀번호:</label>
                <input type="password" id="pwd" name="pwd" value="1234" required>
            </div>
            <div>
                <label for="name">이름:</label>
                <input type="text" id="name" name="name" value="차범근" required>
            </div>
            <div>
                <label for="email">이메일:</label>
                <input type="email" id="email" name="email" value="cha@test.com" required>
            </div>
            <div>
                <label for="address">주소:</label> <%-- 이미지에는 없지만 결과 화면에 있어서 추가 --%>
                <input type="text" id="address" name="address" value="서울시 강남구" required>
            </div>
            <div style="text-align: center; margin-top: 20px;">
                <input type="submit" value="가입하기">
                <input type="reset" value="다시입력">
            </div>
        </form>
    </div>
</body>
</html>
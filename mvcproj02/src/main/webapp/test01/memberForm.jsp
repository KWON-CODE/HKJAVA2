<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
    form { width: 50%; margin: 20px auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
    label { display: inline-block; width: 100px; margin-bottom: 10px; }
    input[type="text"], input[type="password"], input[type="email"] { width: calc(100% - 120px); padding: 8px; margin-bottom: 10px; border: 1px solid #ddd; border-radius: 3px; }
    input[type="submit"] { padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }
    input[type="submit"]:hover { background-color: #45a049; }
    .button-container { text-align: center; margin-top: 10px; }
</style>
</head>
<body>
    <h2 style="text-align:center;">회원 가입</h2>
    <form method="post" action="${pageContext.request.contextPath}/member/addMember.do">
        <div>
            <label for="id">아이디:</label>
            <input type="text" id="id" name="id" required>
        </div>
        <div>
            <label for="pwd">비밀번호:</label>
            <input type="password" id="pwd" name="pwd" required>
        </div>
        <div>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="email">이메일:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <%-- joinDate는 서버에서 자동 생성 --%>
        <div class="button-container">
            <input type="submit" value="가입하기">
        </div>
    </form>
</body>
</html>
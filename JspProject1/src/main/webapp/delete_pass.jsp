<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>글 삭제</title></head>
<body>
    <h2 style="text-align:center;">글 삭제</h2>
    <form action="delete_input.jsp" method="post" style="text-align:center;">
        <input type="hidden" name="numseq" value="${param.numseq}">
        비밀번호: <input type="password" name="pass" required>
        <input type="submit" value="삭제">
        <input type="button" value="취소" onclick="location.href='view.jsp?numseq=${param.numseq}'">
    </form>
</body>
</html>

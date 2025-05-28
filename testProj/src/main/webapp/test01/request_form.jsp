<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Request Test Form</h2>
<hr>
<form method="get" action="request_result.jsp">
<table border=1 cellspacing="1" cellpadding="5">
<tr><td>이름</td><td><input type="text" size="10" name="username"></td></tr>
<tr><td>학년</td>
<td>
<select name="degree">
<option selected> 1학년 </option>
<option>2학년</option>
<option>3학년</option>
<option>4학년</option>
</select>
</td>
</tr>
<tr>
<td>관심분야</td>
<td>
<input type="checkbox" name="favorite" value="사회">사회</input>
<input type="checkbox" name="favorite" value="경제">경제</input>
<input type="checkbox" name="favorite" value="정보">"정보"</input>
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="확인"> <input type="reset" value="취소"></td>
</tr>
</table>
</form>

</body>
</html>
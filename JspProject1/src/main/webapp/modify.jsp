<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ include file="DBConTest.jsp" %>
<%
    int numseq = 0;
    try { numseq = Integer.parseInt(request.getParameter("numseq")); }
    catch(Exception e){ out.println("잘못된 접근"); return; }

    PreparedStatement ps = conn.prepareStatement(
      "SELECT num, name, pass, email, title, contents, writedate " +
      "FROM tblboard WHERE numseq = ?");
    ps.setInt(1, numseq);
    ResultSet rs = ps.executeQuery();
    if (!rs.next()) { out.println("존재하지 않는 글입니다."); return; }
    int    num       = rs.getInt("num");
    String name      = rs.getString("name");
    String pass      = rs.getString("pass");
    String email     = rs.getString("email");
    String title     = rs.getString("title");
    String contents  = rs.getString("contents");
    String writedate = rs.getString("writedate");
    rs.close(); ps.close(); conn.close();
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>글 수정</title></head>
<body>
    <h2 style="text-align:center;">게시글 수정</h2>
    <form action="modify_input.jsp" method="post" style="width:600px;margin:auto;">
        <input type="hidden" name="numseq" value="<%=numseq%>">
        <table width="100%" cellpadding="5" border="1">
            <tr>
                <th>번호</th>
                <td><%= num %></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="name" value="<%=name%>" disabled></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="pass" value="<%=pass%>"></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" name="email" value="<%=email%>"></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value="<%=title%>"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="contents" rows="8" style="width:100%;"><%=contents%></textarea></td>
            </tr>
            <tr>
                <th>작성일</th>
                <td><input type="text" name="writedate" value="<%=writedate%>"></td>
            </tr>
        </table>
        <div style="text-align:center; margin:10px;">
            <input type="submit" value="수정완료">
            <input type="button" value="취소" onclick="location.href='view.jsp?numseq=<%=numseq%>'">
        </div>
    </form>
</body>
</html>

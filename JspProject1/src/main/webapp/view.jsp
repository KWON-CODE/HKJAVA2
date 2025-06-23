<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ include file="DBConTest.jsp" %>
<%
    int numseq = 0;
    try { numseq = Integer.parseInt(request.getParameter("numseq")); }
    catch(Exception e){ out.println("잘못된 접근"); return; }

    // 1) 조회수 증가
    PreparedStatement psUp = conn.prepareStatement(
      "UPDATE tblboard SET readcount = readcount + 1 WHERE numseq = ?");
    psUp.setInt(1, numseq);
    psUp.executeUpdate();
    psUp.close();

    // 2) 상세 조회
    PreparedStatement ps = conn.prepareStatement(
      "SELECT num, name, title, contents, email, writedate, readcount " +
      "FROM tblboard WHERE numseq = ?");
    ps.setInt(1, numseq);
    ResultSet rs = ps.executeQuery();
    if (!rs.next()) {
        out.println("존재하지 않는 글입니다.");
        return;
    }
    int num       = rs.getInt("num");
    String name   = rs.getString("name");
    String title  = rs.getString("title");
    String contents = rs.getString("contents");
    String email  = rs.getString("email");
    String writedate = rs.getString("writedate");
    int readcount = rs.getInt("readcount");
    rs.close();
    ps.close();
    conn.close();
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>글 상세보기</title></head>
<body>
    <h2 style="text-align:center;">게시글 상세보기</h2>
    <table border="1" width="60%" align="center" cellpadding="5">
        <tr><th>번호</th><td><%=num%></td></tr>
        <tr><th>제목</th><td><%=title%></td></tr>
        <tr><th>작성자</th><td><%=name%></td></tr>
        <tr><th>이메일</th><td><%=email%></td></tr>
        <tr><th>작성일</th><td><%=writedate%></td></tr>
        <tr><th>조회수</th><td><%=readcount%></td></tr>
        <tr><th>내용</th><td><pre><%=contents%></pre></td></tr>
    </table>
    <div style="text-align:center; margin:20px;">
        <a href="modify.jsp?numseq=<%=numseq%>">수정</a>
        <a href="delete_pass.jsp?numseq=<%=numseq%>">삭제</a>
        <a href="reply.jsp?numseq=<%=numseq%>">답글</a>
        <a href="listboard.jsp">목록</a>
    </div>
</body>
</html>

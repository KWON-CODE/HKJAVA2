<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ include file="DBConTest.jsp" %>
<%
    // 1) 파라미터 검증
    int parentNumseq = 0;
    try {
        parentNumseq = Integer.parseInt(request.getParameter("numseq"));
    } catch(Exception e) {
        out.println("<p>잘못된 접근입니다.</p>"); return;
    }

    // 2) 부모 게시글 조회 (ref, re_step, re_level도 함께 읽어둠)
    String parentTitle = "";
    int ref = 0, re_step = 0, re_level = 0;
    PreparedStatement ps = conn.prepareStatement(
        "SELECT title, ref, re_step, re_level FROM tblboard WHERE numseq = ?");
    ps.setInt(1, parentNumseq);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        parentTitle = rs.getString("title");
        ref         = rs.getInt("ref");
        re_step     = rs.getInt("re_step");
        re_level    = rs.getInt("re_level");
    } else {
        out.println("<p>존재하지 않는 글입니다.</p>");
        rs.close(); ps.close(); conn.close();
        return;
    }
    rs.close(); ps.close();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>답변 쓰기</title>
    <style>
      form { width:600px; margin:30px auto; }
      table { width:100%; border-collapse:collapse; }
      td { padding:8px; }
      input[type=text], input[type=password], textarea {
        width:100%; box-sizing:border-box;
      }
      .btn { text-align:center; margin-top:10px; }
    </style>
</head>
<body>
    <h2 style="text-align:center;">&#8627; 답변 쓰기</h2>

    <form action="reply_input.jsp" method="post">
      <!-- 답변 대상 글 정보 -->
      <input type="hidden" name="parentNumseq" value="<%=parentNumseq%>">
      <input type="hidden" name="ref"          value="<%=ref%>">
      <input type="hidden" name="re_step"      value="<%=re_step%>">
      <input type="hidden" name="re_level"     value="<%=re_level%>">

      <table border="1">
        <tr>
          <td>원글 제목</td>
          <td><%= parentTitle %></td>
        </tr>
        <tr>
          <td>작성자</td>
          <td><input type="text" name="name" required></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" name="pass" required></td>
        </tr>
        <tr>
          <td>이메일</td>
          <td><input type="text" name="email"></td>
        </tr>
        <tr>
          <td>제목</td>
          <td><input type="text" name="title" value="RE: <%=parentTitle%>" required></td>
        </tr>
        <tr>
          <td>내용</td>
          <td><textarea name="contents" rows="8" required></textarea></td>
        </tr>
        <tr>
          <td>작성일</td>
          <td><input type="text" name="writedate"
                     value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>" required>
          </td>
        </tr>
      </table>

      <div class="btn">
        <input type="submit" value="답변등록">
        <input type="button" value="취소" onclick="history.back();">
      </div>
    </form>
</body>
</html>

<%
  conn.close();
%>

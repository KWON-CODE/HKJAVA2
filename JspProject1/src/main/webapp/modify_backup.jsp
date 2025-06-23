<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ include file="DBConTest.jsp" %>  

<%
    // 1) 요청 파라미터에서 num 값 가져오기
    String numParam = request.getParameter("num");
    int num = 0;
    if (numParam != null) {
        try {
            num = Integer.parseInt(numParam);
        } catch (NumberFormatException e) {
            out.println("<p>잘못된 접근입니다.</p>");
            return;
        }
    } else {
        out.println("<p>글 번호가 지정되지 않았습니다.</p>");
        return;
    }

    // 2) DB에서 해당 레코드 조회
    String name="", pass="", email="", title="", contents="", writedate="";
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        String sql = "SELECT name, pass, email, title, contents "
                   + "FROM tblboard WHERE num = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, num);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            name      = rs.getString("name");
            pass      = rs.getString("pass");
            email     = rs.getString("email");
            title     = rs.getString("title");
            contents  = rs.getString("contents");
  
        } else {
            out.println("<p>존재하지 않는 글입니다.</p>");
            return;
        }
    } catch (Exception e) {
        throw new ServletException(e);
    } finally {
        if (rs   != null) try { rs.close();   } catch(Exception ignore){}
        if (pstmt!= null) try { pstmt.close();} catch(Exception ignore){}
        if (conn != null) try { conn.close(); } catch(Exception ignore){}
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
    <style>
        /* write.jsp 스타일과 통일되도록 간단히 재정의 */
        .form-table { width: 600px; margin: 20px auto; border-collapse: collapse; }
        .form-table td { padding: 8px; }
        .form-table input[type=text],
        .form-table input[type=password],
        .form-table textarea { width: 100%; }
        .btn-wrap { text-align: center; margin-top: 10px; }
    </style>
</head>
<body>
<jsp:include page="WEB-INF/jsp/include/menu.jsp"></jsp:include>
    <h2 style="text-align:center;">게시글 수정</h2>
    <form action="modify_input.jsp" method="post">
        <input type="hidden" name="num" value="<%= num %>">

        <table class="form-table" border="1">
            <tr>
                <td>작성자</td>
                <!-- disabled 처리 -->
                <td><input type="text" name="name" value="<%= name %>" disabled></td>
            </tr>       
            <tr>
                <td>제목</td>
                <td><input type="text" name="title" value="<%= title %>"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td>
                    <textarea name="contents" rows="8"><%= contents %></textarea>
                </td>
            </tr>
         
        </table>

        <div class="btn-wrap">
            <input type="submit" value="수정완료">
            <input type="button" value="취소" onclick="location.href='view.jsp?num=<%= num %>';">
        </div>
    </form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ include file="DBConTest.jsp" %>

<%
    // 1. 한글 깨짐 방지
    request.setCharacterEncoding("UTF-8");

    // 2. 파라미터 가져오기
    String numParam = request.getParameter("num");
    String passParam = request.getParameter("pass");
    int num = 0;
    try {
        num = Integer.parseInt(numParam);
    } catch (NumberFormatException e) {
        // 잘못된 num 파라미터면 목록으로 이동
        response.sendRedirect("listboard.jsp");
        return;
    }
    PreparedStatement pstmt = null;
    int deletedCount = 0;

    try {
       
        // 4. 비밀번호가 일치하는 경우에만 삭제
        String sql = "DELETE FROM tblboard WHERE num = ? AND pass = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, num);
        pstmt.setString(2, passParam);
        deletedCount = pstmt.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (pstmt != null) try { pstmt.close(); } catch (Exception ignore) {}
        if (conn  != null) try { conn.close();  } catch (Exception ignore) {}
    }

    // 5. 삭제 결과에 따라 처리
    if (deletedCount > 0) {
        // 삭제 성공 시 목록으로 이동
        response.sendRedirect("listboard.jsp");
    } else {
        // 비밀번호 불일치 또는 존재하지 않는 게시글
%>
        <script>
            alert("비밀번호가 일치하지 않거나 게시글이 존재하지 않습니다.");
            history.back();
        </script>
<%
    }
%>

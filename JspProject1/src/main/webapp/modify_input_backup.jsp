<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ include file="DBConTest.jsp" %>

<%
    // 0. 인코딩
    request.setCharacterEncoding("UTF-8");

    // 1. 파라미터 꺼내기
    String numParam    = request.getParameter("num");
    String pass        = request.getParameter("pass");
    String email       = request.getParameter("email");
    String title       = request.getParameter("title");
    String contents    = request.getParameter("contents");
    String writedate   = request.getParameter("writedate");

    int num = 0;
    try {
        num = Integer.parseInt(numParam);
    } catch(NumberFormatException e) {
        // 비정상 접근 시 listboard.jsp로 돌아가기
        response.sendRedirect("listboard.jsp");
        return;
    }

    PreparedStatement pstmt = null;

    try {
        // 3. UPDATE 문 실행
        String sql = "UPDATE tblboard SET title = ?, contents = ? WHERE num = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, contents);
        pstmt.setInt(3, num);

        int updated = pstmt.executeUpdate();
        // 필요시 updated == 0 체크 가능

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (pstmt != null) try { pstmt.close(); } catch (Exception ignore) {}
        if (conn  != null) try { conn.close();  } catch (Exception ignore) {}
    }

    // 4. 수정 후 목록으로 리다이렉트
    response.sendRedirect("listboard.jsp");
%>

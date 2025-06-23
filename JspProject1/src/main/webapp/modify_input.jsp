<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ include file="DBConTest.jsp" %>
<%
    request.setCharacterEncoding("UTF-8");
    int numseq = Integer.parseInt(request.getParameter("numseq"));
    String pass      = request.getParameter("pass");
    String email     = request.getParameter("email");
    String title     = request.getParameter("title");
    String contents  = request.getParameter("contents");
    String writedate = request.getParameter("writedate");

    String sql = 
      "UPDATE tblboard SET pass=?, email=?, title=?, contents=?, writedate=? " +
      "WHERE numseq = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, pass);
    ps.setString(2, email);
    ps.setString(3, title);
    ps.setString(4, contents);
    ps.setString(5, writedate);
    ps.setInt(6, numseq);
    ps.executeUpdate();
    ps.close();
    conn.close();

    response.sendRedirect("listboard.jsp");
%>

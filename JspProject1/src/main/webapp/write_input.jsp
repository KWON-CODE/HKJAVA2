<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.* , java.util.*" %>
<%@ include file="DBConTest.jsp" %>
<%
    // 1) 한글 깨짐
    request.setCharacterEncoding("UTF-8");

    // 2) 폼 파라미터
    String name     = request.getParameter("name");
    String pass     = request.getParameter("pass");
    String email    = request.getParameter("email");
    String title    = request.getParameter("title");
    String contents = request.getParameter("contents");
   
    // 날짜정보 
    Calendar dateIn = Calendar.getInstance();    //Calendar 클래스 참고
    String indate = Integer.toString(dateIn.get(Calendar.YEAR)) + "-";
    indate = indate + Integer.toString(dateIn.get(Calendar.MONTH)+1) + "-";
    indate = indate + Integer.toString(dateIn.get(Calendar.DATE)) + " ";
    indate = indate + Integer.toString(dateIn.get(Calendar.HOUR_OF_DAY)) + ":";
    indate = indate + Integer.toString(dateIn.get(Calendar.MINUTE)) + ":";
    indate = indate + Integer.toString(dateIn.get(Calendar.SECOND));
    

    // 3) 새 NUM 계산: max(num) + 1
    int nextNum = 1;
    PreparedStatement psMax = null;
    ResultSet rsMax = null;
    try {
        String maxSql = "SELECT NVL(MAX(num),0) FROM tblboard";
        psMax = conn.prepareStatement(maxSql);
        rsMax = psMax.executeQuery();
        if (rsMax.next()) {
            nextNum = rsMax.getInt(1) + 1;
        }
    } finally {
        if (rsMax != null)  rsMax.close();
        if (psMax != null)  psMax.close();
    }

    // 4) INSERT (NUMSEQ, …, NUM)
    String insertSql = 
      "INSERT INTO tblboard (numseq, name, pass, email, title, contents, writedate, readcount, ref, re_step, re_level, num) " +
      "VALUES (num_seq.nextval, ?, ?, ?, ?, ?, ?, ?, num_seq.currval, 0, 0, ?)";
    PreparedStatement psIns = conn.prepareStatement(insertSql);
    psIns.setString(1, name);
    psIns.setString(2, pass);
    psIns.setString(3, email);
    psIns.setString(4, title);
    psIns.setString(5, contents);
    psIns.setString(6, indate);
    psIns.setInt(7, 0);        // 처음 조회수
    psIns.setInt(8, nextNum);  // 새 순번
    psIns.executeUpdate();
    psIns.close();

    // 5) 완료 후 목록으로
    conn.close();
    response.sendRedirect("listboard.jsp");
%>

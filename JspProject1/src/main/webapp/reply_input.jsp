<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ include file="DBConTest.jsp" %>
<%
    request.setCharacterEncoding("UTF-8");
    // 1) 파라미터
    int parentNumseq = Integer.parseInt(request.getParameter("parentNumseq"));
    int ref          = Integer.parseInt(request.getParameter("ref"));
    int re_step      = Integer.parseInt(request.getParameter("re_step"));
    int re_level     = Integer.parseInt(request.getParameter("re_level"));

    String name      = request.getParameter("name");
    String pass      = request.getParameter("pass");
    String email     = request.getParameter("email");
    String title     = request.getParameter("title");
    String contents  = request.getParameter("contents");
    String writedate = request.getParameter("writedate");

    // 2) 기존 답변 순서(re_step) 재정렬
    // 같은 그룹(ref) 내에서, parent의 바로 다음 순위로 끼워넣기 위해
    PreparedStatement psUpd = conn.prepareStatement(
      "UPDATE tblboard " +
      "SET re_step = re_step + 1 " +
      "WHERE ref = ? AND re_step > ?");
    psUpd.setInt(1, ref);
    psUpd.setInt(2, re_step);
    psUpd.executeUpdate();
    psUpd.close();

    // 3) 새 답변 INSERT
    // NUMSEQ, NUM 계산 로직은 write_input.jsp와 동일하게
    // → NUMSEQ via sequence, NUM via MAX(num)+1
    // → 답글은 순차번호(NUM) 증가하지 않고, NUM으로 정렬하지 않을 수도 있으나
    //    여기서는 NUM도 글쓰기 순으로 증가시킵니다.
    int nextNum = 1;
    PreparedStatement psMax = conn.prepareStatement("SELECT NVL(MAX(num),0) FROM tblboard");
    ResultSet rsMax = psMax.executeQuery();
    if (rsMax.next()) nextNum = rsMax.getInt(1) + 1;
    rsMax.close(); psMax.close();

    String insSql =
      "INSERT INTO tblboard " +
      "(numseq, name, pass, email, title, contents, writedate, readcount, num, ref, re_step, re_level) " +
      "VALUES (num_seq.nextval, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?)";
    PreparedStatement psIns = conn.prepareStatement(insSql);
    psIns.setString(1, name);
    psIns.setString(2, pass);
    psIns.setString(3, email);
    psIns.setString(4, title);
    psIns.setString(5, contents);
    psIns.setString(6, writedate);
    psIns.setInt(7, nextNum);
    psIns.setInt(8, ref);
    psIns.setInt(9, re_step + 1);
    psIns.setInt(10,re_level + 1);
    psIns.executeUpdate();
    psIns.close();

    conn.close();

    // 4) 답변 완료 후 목록으로
    response.sendRedirect("listboard.jsp");
%>

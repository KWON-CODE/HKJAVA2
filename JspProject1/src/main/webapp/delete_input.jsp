<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ include file="DBConTest.jsp" %>
<%
    request.setCharacterEncoding("UTF-8");
    int numseq = 0;
    try { numseq = Integer.parseInt(request.getParameter("numseq")); }
    catch(Exception e){ response.sendRedirect("listboard.jsp"); return; }
    String pass = request.getParameter("pass");

    // 1) 비밀번호 검증 & NUM 읽기
    int deletedNum = -1;
    PreparedStatement psSel = conn.prepareStatement(
        "SELECT num FROM tblboard WHERE numseq = ? AND pass = ?");
    psSel.setInt(1, numseq);
    psSel.setString(2, pass);
    ResultSet rsSel = psSel.executeQuery();
    if (rsSel.next()) {
        deletedNum = rsSel.getInt("num");
    }
    rsSel.close();
    psSel.close();

    if (deletedNum < 0) {
        // 비밀번호 불일치
%>
<script>
    alert("비밀번호가 일치하지 않거나 게시글이 존재하지 않습니다.");
    history.back();
</script>
<%
        return;
    }

    // 2) 실제 삭제 (PK 기준)
    PreparedStatement psDel = conn.prepareStatement(
        "DELETE FROM tblboard WHERE numseq = ?");
    psDel.setInt(1, numseq);
    psDel.executeUpdate();
    psDel.close();

    // 3) 순번 재배치 (NUM > deletedNum)
    PreparedStatement psUpd = conn.prepareStatement(
        "UPDATE tblboard SET num = num - 1 WHERE num > ?");
    psUpd.setInt(1, deletedNum);
    psUpd.executeUpdate();
    psUpd.close();

    conn.close();
    response.sendRedirect("listboard.jsp");
%>

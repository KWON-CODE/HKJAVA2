<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, javax.sql.*, javax.naming.*" %>
<%@ include file="DBConTest.jsp" %>  

<%
PreparedStatement pstmt=null;
ResultSet rs =null;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
</head>
<body>
<jsp:include page="WEB-INF/jsp/include/menu.jsp"></jsp:include>
    <center>
        <font size="3"><b>게시판 목록</b></font>
    </center>
    <br/>

    <table border="0" width="600" cellpadding="0" cellspacing="0" align="center">
        <tr>
            <td>
                <!-- 실제 데이터 테이블 -->
                <table border="1" width="100%" cellpadding="5" cellspacing="0">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
<%
    // --- 데이터 조회 (write_input.jsp INSERT를 참고하여 컬럼명을 맞춤) ---
    try {
        String sql = "SELECT num, title, name, writedate, readcount FROM tblboard ORDER BY num DESC";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
%>
                    <tr>
                        <td align="center"><%= rs.getInt("num") %></td>
                        <td>
                            <a href="view.jsp?num=<%= rs.getInt("num") %>">
                                <%= rs.getString("title") %>
                            </a>
                        </td>
                        <td align="center"><%= rs.getString("name") %></td>
                        <td align="center"><%= rs.getString("writedate") %></td>
                        <td align="center"><%= rs.getInt("readcount") %></td>
                    </tr>
<%
        }
    } catch (Exception e) {
%>
                    <tr>
                        <td colspan="5" align="center">오류 발생: <%= e.getMessage() %></td>
                    </tr>
<%
    } finally {
        if (rs   != null) try { rs.close();   } catch (Exception ignore) {}
        if (pstmt!= null) try { pstmt.close();} catch (Exception ignore) {}
        if (conn != null) try { conn.close(); } catch (Exception ignore) {}
    }
%>
                </table>
            </td>
        </tr>
    </table>

    <div style="text-align:center; margin-top:20px;">
        <a href="write.jsp">[글쓰기]</a>
    </div>
</body>
</html>

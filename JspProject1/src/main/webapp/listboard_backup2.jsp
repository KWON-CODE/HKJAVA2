<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%@ include file="DBConTest.jsp" %>  

<%
    // 1) 한글 깨짐 방지
    request.setCharacterEncoding("UTF-8");

    // 2) 검색 파라미터 읽기
    String searchField = request.getParameter("searchField");
    String searchWord  = request.getParameter("searchWord");
    if (searchField == null) searchField = "title";   // 기본값
    if (searchWord  == null) searchWord  = "";

    // 3) DB 연결 및 쿼리 준비
    PreparedStatement pstmt = null;
    ResultSet rs       = null;
    try {
        
        // 기본 SELECT
        String sql = "SELECT num, title, name, writedate, readcount FROM tblboard";

        // 검색어가 있을 때만 WHERE 절 추가
        if (!searchWord.trim().isEmpty()) {
            // 허용할 컬럼만 직접 매핑하여 SQL 인젝션 방지
            String col;
            switch (searchField) {
                case "name":     col = "name";     break;
                case "contents": col = "contents"; break;
                default:         col = "title";    break;
            }
            sql += " WHERE " + col + " LIKE ?";
        }

        sql += " ORDER BY num DESC";

        pstmt = conn.prepareStatement(sql);
        if (!searchWord.trim().isEmpty()) {
            pstmt.setString(1, "%" + searchWord + "%");
        }
        rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <style>
        table { width:80%; margin:auto; border-collapse:collapse; }
        th, td { border:1px solid #ccc; padding:8px; text-align:center; }
        th { background:#f2f2f2; }
        .search-form { width:80%; margin:20px auto; text-align:right; }
        .write-link { text-align:center; margin:20px; }
    </style>
</head>
<body>
<jsp:include page="WEB-INF/jsp/include/menu.jsp"></jsp:include>
    <h2 style="text-align:center;">게시판 글 목록</h2>

    <!-- 4) 검색 폼 -->
    <div class="search-form">
        <form action="listboard.jsp" method="get">
            <select name="searchField">
                <option value="title"    <%= "title".equals(searchField)    ? "selected" : "" %>>글제목</option>
                <option value="name"     <%= "name".equals(searchField)     ? "selected" : "" %>>작성자</option>
                <option value="contents" <%= "contents".equals(searchField) ? "selected" : "" %>>내용</option>
            </select>
            <input type="text" name="searchWord" value="<%= searchWord %>" placeholder="검색어 입력">
            <input type="submit" value="검색">
        </form>
    </div>

    <!-- 5) 결과 테이블 -->
    <table>
        <tr>
            <th>번호</th>
            <th>글 제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
        <%
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("num") %></td>
            <td>
                <a href="view.jsp?num=<%= rs.getInt("num") %>">
                    <%= rs.getString("title") %>
                </a>
            </td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("writedate") %></td>
            <td><%= rs.getInt("readcount") %></td>
        </tr>
        <%
            }
        %>
    </table>

    <!-- 글쓰기 버튼 -->
    <div class="write-link">
        <a href="write.jsp">[글쓰기]</a>
    </div>
</body>
</html>
<%
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs    != null) try{ rs.close();    } catch(Exception ignore){}
        if (pstmt != null) try{ pstmt.close(); } catch(Exception ignore){}
        if (conn  != null) try{ conn.close();  } catch(Exception ignore){}
    }
%>

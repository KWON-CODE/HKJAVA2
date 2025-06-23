<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%
    // 1. 한글 깨짐 방지
    request.setCharacterEncoding("UTF-8");

    // 2. 검색 파라미터
    String searchField = request.getParameter("searchField");
    String searchWord  = request.getParameter("searchWord");
    if (searchField == null) searchField = "title";
    if (searchWord  == null) searchWord  = "";

    // 3. 페이징 파라미터 (변수명 변경)
    int currentPage = 1;
    try {
        currentPage = Integer.parseInt(request.getParameter("page"));
        if (currentPage < 1) currentPage = 1;
    } catch (Exception e) { /* 무시 */ }

    final int pageSize = 10;
    int start = (currentPage - 1) * pageSize + 1;
    int end   = currentPage * pageSize;

    // 4. WHERE 절 (검색어 있을 때만)
    String where = "";
    if (!searchWord.trim().isEmpty()) {
        String col = "TITLE";
        if ("name".equals(searchField))       col = "NAME";
        else if ("contents".equals(searchField)) col = "CONTENTS";
        where = " WHERE " + col + " LIKE ?";
    }

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    int totalCount = 0;
    int totalPage  = 1;

    try {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myoracle");
        conn = ds.getConnection();

        // 5. 전체 건수 조회
        String cntSql = "SELECT COUNT(*) FROM tblboard" + where;
        pstmt = conn.prepareStatement(cntSql);
        if (!where.isEmpty()) pstmt.setString(1, "%" + searchWord + "%");
        rs = pstmt.executeQuery();
        if (rs.next()) totalCount = rs.getInt(1);
        rs.close();
        pstmt.close();

        // 6. 총 페이지 수 계산
        totalPage = (int) Math.ceil((double) totalCount / pageSize);

        // 7. 페이징 데이터 조회 (ROWNUM 활용)
        String dataSql =
          "SELECT * FROM ( " +
          "  SELECT ROWNUM rn, A.* FROM ( " +
          "    SELECT NUMSEQ, TITLE, NAME, WRITEDATE, READCOUNT " +
          "      FROM tblboard" + where + " " +
          "      ORDER BY NUMSEQ DESC " +
          "  ) A WHERE ROWNUM <= ? " +
          ") WHERE rn >= ?";
        pstmt = conn.prepareStatement(dataSql);

        int idx = 1;
        if (!where.isEmpty()) {
            pstmt.setString(idx++, "%" + searchWord + "%");
        }
        pstmt.setInt(idx++, end);
        pstmt.setInt(idx,   start);
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
        .pagination { text-align:center; margin:20px; }
        .pagination a { margin: 0 5px; text-decoration:none; color:blue; }
        .pagination span.current { margin: 0 5px; font-weight:bold; }
        .write-link { text-align:center; margin:20px; }
    </style>
</head>
<body>
    <h2 style="text-align:center;">게시판 글 목록</h2>

    <!-- 검색 -->
    <div class="search-form">
        <form action="listboard.jsp" method="get">
            <select name="searchField">
                <option value="title"    <%= "title".equals(searchField)    ? "selected":"" %>>글제목</option>
                <option value="name"     <%= "name".equals(searchField)     ? "selected":"" %>>작성자</option>
                <option value="contents" <%= "contents".equals(searchField) ? "selected":"" %>>내용</option>
            </select>
            <input type="text" name="searchWord" value="<%= searchWord %>" placeholder="검색어">
            <input type="submit" value="검색">
        </form>
    </div>

    <!-- 결과 테이블 -->
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
            <td><%= rs.getInt("NUMSEQ") %></td>
            <td>
                <a href="view.jsp?numseq=<%= rs.getInt("NUMSEQ") %>">
                    <%= rs.getString("TITLE") %>
                </a>
            </td>
            <td><%= rs.getString("NAME") %></td>
            <td><%= rs.getString("WRITEDATE") %></td>
            <td><%= rs.getInt("READCOUNT") %></td>
        </tr>
        <%
            }
        %>
    </table>

    <!-- 페이지 네비게이션 -->
    <div class="pagination">
        <%
            // [이전]
            if (currentPage > 1) {
        %>
            <a href="listboard.jsp?page=<%=currentPage-1%>&searchField=<%=searchField%>&searchWord=<%=searchWord%>">[이전]</a>
        <%
            }
            // 페이지 번호
            for (int i = 1; i <= totalPage; i++) {
                if (i == currentPage) {
        %>
            <span class="current">[<%= i %>]</span>
        <%
                } else {
        %>
            <a href="listboard.jsp?page=<%= i %>&searchField=<%=searchField%>&searchWord=<%=searchWord%>">[<%= i %>]</a>
        <%
                }
            }
            // [다음]
            if (currentPage < totalPage) {
        %>
            <a href="listboard.jsp?page=<%=currentPage+1%>&searchField=<%=searchField%>&searchWord=<%=searchWord%>">[다음]</a>
        <%
            }
        %>
    </div>

    <!-- 글쓰기 -->
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

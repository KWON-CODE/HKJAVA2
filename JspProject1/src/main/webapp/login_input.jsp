<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ include file="DBConTest.jsp" %>

<%
    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");
    String pass = request.getParameter("pass");

    // DB 접속 정보 (본인 환경에 맞게 수정)
   /*  String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String dbUser = "your_oracle_user";
    String dbPass = "your_oracle_password";

    Connection conn = null; */
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
       /*  Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, dbUser, dbPass); */

        // 해당 id가 존재하는지 검색
        String sql = "SELECT pass,name FROM tblmember WHERE id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();

        if (!rs.next()) { // id 없음 → 가입페이지로 이동
%>
            <script>
                alert("해당 아이디가 없습니다. 회원가입 페이지로 이동합니다.");
                location.href = "register.jsp";
            </script>
<%
        } else {
            String dbPwd = rs.getString("pass");
            String name= rs.getString("name");
            if (pass.equals(dbPwd)) { // 로그인 성공
                // (여기에 세션 처리 등 로그인 후 동작 추가 가능)
	// 쿠키 생성 (유효기간: 1시간, 필요시 수정)
                Cookie idCookie = new Cookie("user_id", id);
                idCookie.setMaxAge(60 * 60);
                response.addCookie(idCookie);
                Cookie nameCookie = new Cookie("user_name", java.net.URLEncoder.encode(name, "UTF-8"));
                nameCookie.setMaxAge(60 * 60);
                response.addCookie(nameCookie);
%>				

                <script>
                    alert("로그인 성공!");
                    location.href = "index.jsp"; // 로그인 성공 후 이동할 페이지로 변경
                </script>
<%
            } else { // 비번 불일치
%>
                <script>
                    alert("비밀번호가 일치하지 않습니다.");
                    history.back();
                </script>
<%
            }
        }
    } catch(Exception e) {
%>
        <script>
            alert("오류 발생: <%=e.getMessage()%>");
            history.back();
        </script>
<%
    } finally {
        try { if(rs != null) rs.close(); } catch(Exception e) {}
        try { if(pstmt != null) pstmt.close(); } catch(Exception e) {}
        try { if(conn != null) conn.close(); } catch(Exception e) {}
    }
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ include file="DBConTest.jsp" %>

<%
    request.setCharacterEncoding("UTF-8");

    String id         = request.getParameter("id");
    String pass       = request.getParameter("pass");
    String name       = request.getParameter("name");
    String juminnum1  = request.getParameter("juminnum1");
    String juminnum2  = request.getParameter("juminnum2");
    String zip        = request.getParameter("zip");
    String address1   = request.getParameter("address1");
    String address2   = request.getParameter("address2");
    String phone      = request.getParameter("phone");
    String email      = request.getParameter("email");

 
    PreparedStatement pstmt = null;

    try {
       
        String sql = "INSERT INTO tblmember " +
                     "(id, pass, name, juminnum1, juminnum2, zip, address1, address2, phone, email) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, pass);
        pstmt.setString(3, name);
        pstmt.setString(4, juminnum1);
        pstmt.setString(5, juminnum2);
        pstmt.setString(6, zip);
        pstmt.setString(7, address1);
        pstmt.setString(8, address2);
        pstmt.setString(9, phone);
        pstmt.setString(10, email);

        int result = pstmt.executeUpdate();

        if (result > 0) {
%>
            <script>
                alert("회원가입이 완료되었습니다.");
                location.href = "login.jsp";
            </script>
<%
        } else {
%>
            <script>
                alert("회원가입에 실패했습니다.");
                history.back();
            </script>
<%
        }
    } catch(Exception e) {
%>
        <script>
            alert("오류 발생: <%=e.getMessage()%>");
            history.back();
        </script>
<%
    } finally {
        try { if (pstmt != null) pstmt.close(); } catch(Exception e) {}
        try { if (conn != null) conn.close(); } catch(Exception e) {}
    }
%>

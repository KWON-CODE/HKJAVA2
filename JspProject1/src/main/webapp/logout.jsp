<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Cookie[] cks = request.getCookies();
    if (cks != null) {
        for (Cookie ck : cks) {
            if ("user_id".equals(ck.getName()) || "user_name".equals(ck.getName())) {
            	  Cookie idCookie = new Cookie("user_id", "");
                  idCookie.setMaxAge(0);
                  response.addCookie(idCookie);

                  Cookie nameCookie = new Cookie("user_name", "");
                  nameCookie.setMaxAge(0);
                  response.addCookie(nameCookie);


                  idCookie.setMaxAge(0);
                  idCookie.setPath("/");          
                  response.addCookie(idCookie);
                  
                  nameCookie.setMaxAge(0);
                  nameCookie.setPath("/");         
                  response.addCookie(nameCookie);
            }
        }
    }
%>
<script>
    alert('로그아웃 되었습니다.');
    location.href = '<%=request.getContextPath()%>/index.jsp';
</script>

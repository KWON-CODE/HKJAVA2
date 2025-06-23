<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <link href="${pageContext.request.contextPath}/css/samsung_style.css" rel="stylesheet">
 <%
    String userId = null;
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
        	System.out.println(cookie.getName());  //콘솔로 검사 
        	
            if ("user_id".equals(cookie.getName())) {
                userId = cookie.getValue();
            }
            if ("user_name".equals(cookie.getName())) {
                userName = java.net.URLDecoder.decode(cookie.getValue(), "UTF-8");
            }
        }
    }
   
%>
<body>
    <div class="header">
        <h1>
            <img src="${pageContext.request.contextPath}/img/logo-samsung.png" alt="삼성 로고" />
        </h1>
        <h2>회사소개</h2>
        <div class="menu">
            <ul class="nav">
                <li><a href="#">삼성생명 소개</a></li>
                <li><a href="#">사회공헌</a></li>
                <li><a href="searchmap.html" target="_blank">오시는길</a></li>
                <li><a href="listboard.jsp">게시판</a></li>
                
                <% if (userId != null && !"".equals(userId)) { %>
    <span><%=userName%>님 환영합니다.</span>
   <li><a href="logout.jsp">로그아웃</a></li>
<% } else { %>
     <li><a href="register.jsp"   target="_blank">회원가입</a></li>
     <li><a href="login.jsp">로그인</a></li>
<% } %>
            </ul>
        </div>
    </div>
</body>
</html>
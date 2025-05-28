<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String emailHost=null;
		String webMaster=null;
		
		public void jspInit(){
			ServletConfig myConfig=getServletConfig();
			emailHost=myConfig.getInitParameter("emailHost");
			webMaster=myConfig.getInitParameter("webMaster");
		}
	%>
	email Server : <%=emailHost %><br>
	webMaster : <%=webMaster %><br>
	E-mail: <%=config.getInitParameter("e-mail") %>
</body>
</html>
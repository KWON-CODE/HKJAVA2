<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*, java.util.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.DataSource"%>
<%@ include file="DBConTest.jsp" %>  

<HTML>
<HEAD>
<TITLE> 상세보기 </TITLE>

<META http-equiv="Content-Type" content="text/html; charset=euc-kr">
</HEAD>

<BODY>
<jsp:include page="WEB-INF/jsp/include/menu.jsp"></jsp:include>
<%
// listboard.jsp의 개인글제목 클릭시 --> write_output.jsp(현재 상세보기)
String num = request.getParameter("num");   //
String pageNum = request.getParameter("pageNum");

PreparedStatement pstmt = null;
ResultSet rs = null;

try {
String strSQL = "SELECT * FROM tblboard WHERE num = ?";
pstmt = conn.prepareStatement(strSQL);
pstmt.setInt(1, Integer.parseInt(num));

rs = pstmt.executeQuery();
rs.next();

String name = rs.getString("name");
String title = rs.getString("title");
String contents = rs.getString("contents").trim();
String writedate = rs.getString("writedate");
int readcount = rs.getInt("readcount");
%>

<center><font size='3'><b> 상세 보기 </b></font>

<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
	<TR>
		<TD><hr size='1' noshade>
		</TD>
 	</TR>
</TABLE>

<TABLE border='0' width='600'>
	<TR>
    		<TD align='left'>
      		<font size='2'> 작성자 : <%=name %></font>
    		</TD>
    		
    		<TD align=right>
      		<font size='2'>작성일: <%=writedate %>, 조회수: <%=readcount %></font>
    		</TD>
    	</TR>
</TABLE>

<TABLE border='0' cellspacing=3 cellpadding=3 width='600'>
	<TR bgcolor='cccccc'>
		<TD align='center'>
    		<font size='3'><b><%=title %></font>
		</TD>
	</TR>
</TABLE>

<TABLE border='0' cellspacing=5 cellpadding=10 width='600'>
	<TR bgcolor='ededed'>
		<TD><font size='2' color=''><%=contents %></font>
		</TD>
	</TR>
</TABLE>

<TABLE border='0' width='600'>
	<TR>
    		<TD align='right'>
		<font size='2'><br><font size='2'></font>
    		</TD>
	</TR>
</TABLE>

<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
  	<TR>
  		<TD><hr size='1' noshade>
  		</TD>
  	</TR>
</TABLE>

<TABLE border='0' width='600'>
	<TR>
		<TD align='right'>
			<a href='write.jsp'>[글쓰기]</a>
			<a href='listboard.jsp?pageNum=<%=pageNum%>'>[목록보기]</a>
			<a href='modify.jsp?num=<%=num %>&pageNum=<%=pageNum%>'>[수정하기] </a>
			<a href='delete_pass.jsp?num=<%=num %>&pageNum=<%=pageNum%>'>[삭제하기] </a>
 		</TD>
	</TR>
</TABLE>

<%
strSQL = "UPDATE tblboard SET readcount=readcount+1 WHERE num = ?";
pstmt = conn.prepareStatement(strSQL);
pstmt.setInt(1, Integer.parseInt(num));
pstmt.executeUpdate();

}catch(SQLException e){
   	out.print("SQL에러 " + e.toString());
}catch(Exception ex){
   	out.print("JSP에러 " + ex.toString());
}finally{  
	rs.close();
	pstmt.close();
	conn.close();
}
%>

</TABLE>

</BODY>
</HTML>
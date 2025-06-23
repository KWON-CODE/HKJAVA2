<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*, java.util.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.DataSource"%>
<%@ include file="DBConTest.jsp" %>  

<%
 
String name   = request.getParameter("name");  
String pass   = request.getParameter("pass"); 
String email  = request.getParameter("email");
String title  = request.getParameter("title");
String contents  = request.getParameter("contents");
out.print(name);

PreparedStatement pstmt = null;


Calendar dateIn = Calendar.getInstance();    //Calendar 클래스 참고
String indate = Integer.toString(dateIn.get(Calendar.YEAR)) + "-";
indate = indate + Integer.toString(dateIn.get(Calendar.MONTH)+1) + "-";
indate = indate + Integer.toString(dateIn.get(Calendar.DATE)) + " ";
indate = indate + Integer.toString(dateIn.get(Calendar.HOUR_OF_DAY)) + ":";
indate = indate + Integer.toString(dateIn.get(Calendar.MINUTE)) + ":";
indate = indate + Integer.toString(dateIn.get(Calendar.SECOND));

String strSQL="select max(num) from tblboard";
pstmt=conn.prepareStatement(strSQL);
ResultSet rs=pstmt.executeQuery();
int num=1;
if (rs.next()) {
	num=rs.getInt(1)+1;
}

strSQL ="INSERT INTO tblboard(num, name, pass, email, title, contents, writedate, readcount)";
strSQL = strSQL + " VALUES (num_seq.nextval, ?, ?, ?, ?, ?, ?, ?)"; 
//out.print("sql성공");
 pstmt = conn.prepareStatement(strSQL);
pstmt.setString(1, name);
pstmt.setString(2, pass);
pstmt.setString(3, email);
pstmt.setString(4, title);
pstmt.setString(5, contents);
pstmt.setString(6, indate);
pstmt.setInt(7, 0);
//pstmt.setInt(8, num);
pstmt.executeUpdate();
                	
pstmt.close();
conn.close();
//out.print("DB삽입성공");
response.sendRedirect("listboard.jsp"); 
%>

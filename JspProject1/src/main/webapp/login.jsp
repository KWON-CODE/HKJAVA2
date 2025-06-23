<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
<center><font size='3'><b>로그인</b></font>

<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
	<TR>
		<TD><hr size='1' noshade>
		</TD>
 	</TR>
</TABLE>

<FORM Name='Member' action="login_input.jsp" method="get"> 
<TABLE align=center width='300' border='0' cellpadding='10' cellspacing='0'>
<TR>
	<TD bgcolor='cccccc' align='right'>
		<font size='2'>ID :</font>
	</TD>
	<TD bgcolor='cccccc' align='center'>
		<input type=text maxlength=10 size=10 name='id'>
	</TD>
	<TD bgcolor='cccccc' align='left'>
		<input type='submit' value='로그인'>
	</TD>
</TR>
<TR>
	<TD bgcolor='cccccc' align='right'>
		<font size='2'>비밀 번호 :
	</TD>
	<TD bgcolor='cccccc' align='center'>
		<input type='password' maxlength='10' size='10' name='pass'>
	</TD>
	<TD bgcolor='cccccc'>
		<font size='2'> <a href="register.jsp">[회원가입]</a> </font>
	</TD>
</TR>
</TABLE>

</FORM>
</body>
</html>
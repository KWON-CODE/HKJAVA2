<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE> 회원 등록 </TITLE>
<BODY>
<center><font size='3'><b> 회원 가입 </b></font>
<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
	<TR>
		<TD><hr size='1' noshade>
		</TD>
 	</TR>
</TABLE>

<FORM Name='Member_Input' method="get" action="register_input.jsp">

<TABLE  border='2' cellSpacing=0 cellPadding=5 align=center>
<TR>
	<TD bgcolor='cccccc' align='center'>
		<font size='2'>아 이 디</font>
	</TD>
	<TD bgcolor='cccccc'>
		<input type='text' maxLength='10' size='10' name="id">
		<input type='button' value='ID 중복검사'>
	</TD>
</TR>
<TR>
	<TD bgcolor='cccccc' align='center'>
		<font size='2'>비 밀 번 호</font>
	</TD>
	<TD bgcolor='cccccc'>
		<input type='password' maxLength='10' size='10' name="pass">
	</TD>
</TR>
<TR>
	<TD bgcolor='cccccc' align='center'>
		<font size='2'>이 름</font>
	</TD>
	<TD bgcolor='cccccc'>
		<input type='text' maxLength='10' size='10' name="name">
	</TD>
</TR>
<TR>
	<TD bgcolor='cccccc' align='center'>
		<font size='2'>주민등록번호</font>
	</TD>
	<TD bgcolor='cccccc'>
		<input type='text' size='6' maxlength='6' name="juminnum1">-
		<input type='text' size='7' maxlength='7' name="juminnum2">
	</TD>
</TR>
<TR>
	<TD bgcolor='cccccc' align='center'>
		<font size='2'>우 편 번 호</font>
	</TD>
	<TD bgcolor='cccccc'>
		<input type='text' maxlength='7' size='7'  name="zip">
		<input type='button' value='우편번호검색'>
	</TD>
</TR>
<TR>
	<TD bgcolor='cccccc' align='center'>
		<font size='2'>주 소</font>
	</TD>
	<TD bgcolor='cccccc'>
		<input type='text' maxlength='50' size='50' name="address1"><BR>
		<input type='text' maxlength='50' size='50' name="address2">
	</TD>
</TR>
<TR>
	<TD bgcolor='cccccc' align='center'>
		<font size='2'>전 화 번 호</font>
	</TD>
	<TD bgcolor='cccccc'>
		<input type='text' maxlength='20' size='20' name="phone">
	</TD>
</TR>
<TR>
	<TD bgcolor='cccccc' align='center'>
		<font size='2'>E - M a i l</font>
	</TD>
	<TD bgcolor='cccccc'>
		<input type='text' maxlength='50' size='50' name="email">
	</TD>
</TR>
</TABLE>

<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
	<TR>
		<TD><hr size='1' noshade>
		</TD>
 	</TR>
</TABLE>

<TABLE>
<TR>
	<TD colspan='2' align='center'>
		<input type='submit' value='회원가입'>
	</TD>
</TR>
</TABLE>
</FORM>
</BODY>
</HTML>
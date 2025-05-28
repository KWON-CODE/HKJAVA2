<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp 페이지</h1>
	<%! 
		String str="jsp....";
	%>
	<% 
	for(int i=1;i<=10;i++) 
		out.println("hello world" +i+"<br>");
	
	%>
	<%
	int num1=100, num2=200;
	int sum= num1+num2;
	%>
	합 :<%=sum%>
	
	<%
		int sum2=0;
	for (int i=1; i<=100;i++)
		sum2+=i;
	out.println("합 :"  + sum2);
	%>
	
	<%
		int sum3=0;
	for (int i=1; i<=100;i++)
		sum3 = sum3+ i;	
		%>
		
		<%
		for (int i=1; i<=99;i++)
		%>
		
		1+2+..........+100= <%= sum3%> <br><br>
		<br><br>
		
		
		<%
		for(int i=1;i<=99;i++) {
			out.print(i+ " ");
		}
		out.print(100+"="+sum3);
		%>
		
		
		<%!
	String str1= "선언문자열";
	public double calcu(double n1, double n2, String op) {
		return 0.0;
		if(op.equals("+")) {
			result=n1+n2;}
		
		else if(op.equals("-"))
			{result= n1-n2;}
		return result;
	};
%>
		
</body>
</html>


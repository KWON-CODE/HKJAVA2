<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%
    	Random random= new Random();
    	for(int i=1;i<=10;i++) {
    		int number= random.nextInt(10)+1;
    		//if(number==5) break;
    		if(number==5) continue;
    			out.print(i+"번째값:" + number+"<br>");
    	}
     %>

    <% 
    	int num=12/3;
    	out.print(num); // System.out.print()
    	System.out.print(num);
    	
    	switch(num) {
    	case 1:
    		out.print("1");
    		break;
    	case 2:
    		out.print("2");
    		break;
    	case 3:
    		out.print("4");
    		break;
    		
   		default:
   			out.print("default");
   			break;
    	}
    %>
    
    
    <%
    	int year=2009;
    	int month=2;
    	int numDays=0;
    	
    	switch(month) {
    	case 1:
    	case 3:
    	case 5:
    	case 7:
    	case 8:
    	case 10:
    	case 12:
    		numDays=31;
    		break;
    	case 4:
    	case 6:
    	case 9:
    	case 11:
    		numDays=30;
    		break;
    	case 2:
    		if((year%4==0) && !(year%100==0) ||(year%400==0))
    		numDays=29;
    		else 
    			numDays=28;
   			break;
    		default:
    			break;


    	}
    %>
    <%
    	String str = "2025/05/08";
    	StringTokenizer st = new StringTokenizer(str, "/");
    	st.countTokens();
    	out.print(st.countTokens() + "개" + "<br>");
    %>
    
    <%
    	while(st.hasMoreTokens()) {
    		
    	
    %>
    st.nextToken()=<%=st.nextToken() %><br>
    <%} %>
    
    
    
    
  
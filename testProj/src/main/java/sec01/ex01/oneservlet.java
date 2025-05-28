package sec01.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.*;

@WebServlet
public class oneservlet extends HttpServlet{
	public void init() throws ServletException{
		System.out.println("init메서드 호출");
	}
	



protected void doPost(HttpServletRequest req,HttpServletResponse resp) 
throws ServletException, IOException
{System.out.println("doget 메서드 호출"); }


public void destroy() {
	System.out.println("destroy 메서드 호출");
}

}
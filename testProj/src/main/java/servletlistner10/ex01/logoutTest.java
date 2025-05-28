package servletlistner10.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator.RequestorType;


@WebServlet("/logout")
public class logoutTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	request.
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out= response.getWriter();
	context=getServletContext();
	
	HttpSession session=request.getSession();
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

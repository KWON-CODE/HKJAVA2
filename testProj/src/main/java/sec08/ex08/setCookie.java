package sec08.ex08;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
/**
 * Servlet implementation class setCookie
 */
@WebServlet("/setCookie")
public class setCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		Date d= new Date();
		Cookie c= new Cookie("cookieTest", URLEncoder.encode("JSP연습", "utf-8"));
		
		c.setMaxAge(24*60*60);
		response.addCookie(c);
		
		System.out.println("현재시간:" + d);
		System.out.println("현재시간을 Cookie로 저장");
	}

}

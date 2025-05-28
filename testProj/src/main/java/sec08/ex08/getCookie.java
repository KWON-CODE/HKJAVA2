package sec08.ex08;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;


@WebServlet("/getCookie")
public class getCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		Cookie[] allValues =request.getCookies();
		for(int i=0; i<allValues.length;i++) {
			out.print("<h2>쿠키값 가져오기</h2>" + URLDecoder.decode(allValues[i].getValue(), "utf-8"));
		}
	}

}

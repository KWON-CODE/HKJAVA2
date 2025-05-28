package sec03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet5
 */
@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		    throws ServletException, IOException {
		    doPost(request, response); // GET 요청도 POST와 동일하게 처리
		}
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String user_id= request.getParameter("user_id");
		String user_pw= request.getParameter("user_pw");
		
		String data="<html>";
		data+="<body>";
		data+="아이디:"+ user_id;
		data+="<br>";
		data+="비밀번호:" + user_pw;
		data+="<br>";
		data+="</body>";
		data+="</html>";
		out.print(data);
	}
}

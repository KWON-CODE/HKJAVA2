package sec03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login6")
public class LoginServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		    throws ServletException, IOException {
		    doPost(request, response); // GET 요청도 POST와 동일하게 처리
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id= request.getParameter("아이디:"+user_id);
		String user_pw= request.getParameter("비밀번호:"+user_pw);
		
		if (user_id!="" && user_id.length()!=0) {
		String data="<html>";
		data+="<body>";
		data+=user_id+ "님 로그인 되셨습니다.";
		data+="</body>";
		data+="</html>";
		out.print(data);
		} else {
		String data="<html>";
		data+="<body>";
		data+="아이디를 입력하세요!!";
		data+="<br>";
		data+="<a href='http://localhost8081/testProj/login6.html'>로그인창 </a>";
		data+="</body>";
		data+="</html>";
		out.print(data);
	}

}
	
}

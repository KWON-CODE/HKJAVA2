package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class inputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		System.out.println("아이디:" + user_id);
		System.out.println("비밀번호" + user_pwd);
		String [] subject = request.getParameterValues("subject");
		
		for (String str : subject) {
			System.out.println("선택한과목" + str);
		}

	}

	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}
}

package session09.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet("/session01")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		HttpSession session=request.getSession();
		out.print("세션 아이디:" + session.getId());
		out.print("최초생성시간 :" + new Date(session.getCreationTime())+ "<br>");
		out.print("최근 세션 접근시간" + new Date(session.getLastAccessedTime()) + "<br>");
		out.print("유효시간 :" + session.getMaxInactiveInterval() + "<br>");
		if (session.isNew())
			out.print("새 세션이 생성됨");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}

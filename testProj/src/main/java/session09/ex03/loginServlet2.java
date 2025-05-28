package session09.ex03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class loginServlet2
 */
@WebServlet("/login2")
public class loginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession();
		String user_id=request.getParameter("user_id");
		String user_pw= request.getParameter("user_pw");
		
		MemberVO mVO = new MemberVO();
		mVO.setId(user_id);
		mVO.setPwd(user_pw);
		
		MemberDAO mDAO=new MemberDAO();
		boolean result=mDAO.isExisted(mVO);
		
		if(result) {
			
		}else {
			out.print("<html><body>회원아이디가 틀림");
			out.print("<a href='login9.html'> 다시로그인 하기 </a>");
			out.print("</body></html>")
		}
	}

}

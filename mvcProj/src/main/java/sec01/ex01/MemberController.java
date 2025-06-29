package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.DocumentHandler;

@WebServlet("/mem.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;
	
	  public void init() throws ServletException {
	        memberDAO = new MemberDAO();
	  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(response,request);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(response,request);
	}

	private void doHandle(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		List membersList = memberDAO.listMember();
		request.setAttribute("memebersList", membersList);
		RequestDispatcher dispatch = request.getRequestDispatcher("mvcProj/test01/listMembers.jsp");
		dispatch.forward(request, response);
		
	}
	
}

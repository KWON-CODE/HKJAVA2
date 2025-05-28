package servletlistner10.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

 @WebServlet("/login11")
public class loginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		HttpSession session=request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");

		loginImp1 loginUser = new loginImp1(user_id,user_pw);
		if(session.isNew())
			session.setAttribute("loginUser", loginUser);
		
		String data= "<html><head>";
		data+="<script>";
		data+="setTimeout('history.go(0);', 5000)";
		data+="</script>";
		data+="</head>";
		data+="<body>";
		data+="아이디는" + loginUser.user_id + "<br>";
		data+="총 접속자수 :" + loginImp1.total_user + "<br>";
		data+="</body></html>";
		out.print(data);
		List list = (ArrayList)context.getAttribute("user_id");
			for(int i=0;i<list.size();i++) {
				out.print(list.get(i) + "<br>");
			}
	}

}

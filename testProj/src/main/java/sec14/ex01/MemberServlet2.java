package sec14.ex01;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher; // Tomcat 10+ (Jakarta EE 9+)
import jakarta.servlet.ServletException;    // Tomcat 10+
import jakarta.servlet.annotation.WebServlet; // Tomcat 10+
import jakarta.servlet.http.HttpServlet;      // Tomcat 10+
import jakarta.servlet.http.HttpServletRequest; // Tomcat 10+
import jakarta.servlet.http.HttpServletResponse; // Tomcat 10+

// Tomcat 9 이하 (Java EE 8)를 사용한다면 javax.servlet.* 을 import 하세요.
// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;


@WebServlet("/memberServlet2") // 이 URL로 요청이 오면 이 서블릿이 처리합니다.
public class MemberServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET 요청이 올 경우 보통 폼을 보여주거나 다른 처리를 하지만, 여기서는 POST로만 처리합니다.
        // 필요하다면 doGet에서도 doPost를 호출하도록 할 수 있습니다.
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 요청 파라미터 인코딩 설정 (한글 깨짐 방지)
        request.setCharacterEncoding("UTF-8");

        // 2. memberForm.jsp에서 전송된 데이터 받기
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd"); // 실제로는 비밀번호를 이렇게 직접 전달/표시하지 않습니다.
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address"); // 추가한 주소 필드

        // 3. 받은 데이터를 request 객체에 속성으로 저장 (forward.jsp에서 사용하기 위함)
        request.setAttribute("id", id);
        request.setAttribute("pwd", pwd); // 보안상 좋지 않으나, 화면 예시대로 구현
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("address", address);

        // 4. forward.jsp로 요청과 응답 객체를 전달 (포워딩)
        //    컨텍스트 경로를 기준으로 절대 경로를 사용하는 것이 좋습니다.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp02/forward.jsp");
        dispatcher.forward(request, response);
    }
}
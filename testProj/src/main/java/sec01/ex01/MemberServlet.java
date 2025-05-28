package sec01.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List; // java.util.List인지 확인

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        MemberDAO dao = new MemberDAO();
        List<MemberVO> list = dao.listMembers(); // 제네릭 타입 명시

        out.print("<html><body>");
        out.print("<h2>회원 정보</h2>"); // 제목 추가
        out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td>"
                + "<td>가입일</td></tr>");

        if (list.isEmpty()) {
            out.print("<tr><td colspan='5' align='center'>조회된 회원이 없습니다.</td></tr>");
        } else {
            for (MemberVO memberVO : list) { // 향상된 for문 사용 권장, (MemberVO) 형변환 불필요
                String id = memberVO.getId();
                String pwd = memberVO.getPwd();
                String name = memberVO.getName();
                String email = memberVO.getEmail();
                Date joinDate = memberVO.getJoinDate();
                out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>"
                        + name + "</td><td>" + email + "</td><td>"
                        + joinDate + "</td></tr>");
            }
        }
        out.print("</table></body></html>");
        out.close(); // PrintWriter 사용 후 닫아주는 것이 좋습니다.
    }
}
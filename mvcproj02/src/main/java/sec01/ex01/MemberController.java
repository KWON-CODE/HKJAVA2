package sec01.ex01;

import java.io.IOException;
import java.util.List;
// import java.text.SimpleDateFormat; // VO가 Date를 직접 받으므로 여기선 불필요
import java.util.Date; // Date 사용

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    MemberDAO memberDAO;

    public void init(ServletConfig config) throws ServletException {
        memberDAO = new MemberDAO();
        System.out.println("MemberController init() - MemberDAO 객체 생성 완료 (joinDate는 Date 타입)");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = null;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String action = request.getPathInfo();
        System.out.println("Controller: action=" + action);

        if (action == null || action.equals("/listMembers.do")) {
            List<MemberVO> membersList = memberDAO.listMembers();
            request.setAttribute("membersList", membersList);
            nextPage = "/test01/listMembers.jsp";
        } else if (action.equals("/addMember.do")) {
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String id = request.getParameter("id");
                String pwd = request.getParameter("pwd");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                Date joinDate = new Date(); // 현재 날짜로 Date 객체 생성

                MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
                memberDAO.addMember(memberVO);
                System.out.println("Controller: 회원 가입 처리 - " + id);
                response.sendRedirect(request.getContextPath() + "/member/listMembers.do");
                return;
            } else {
                nextPage = "/test01/memberForm.jsp";
            }
        } else if (action.equals("/memberForm.do")) {
             nextPage = "/test01/memberForm.jsp";
        } else if (action.equals("/modMemberForm.do")) {
            String id = request.getParameter("id");
            MemberVO memInfo = memberDAO.findMember(id);
            request.setAttribute("memInfo", memInfo);
            nextPage = "/test01/modMemberForm.jsp";
        } else if (action.equals("/updateMember.do")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            MemberVO originalMember = memberDAO.findMember(id);
            Date joinDate;
            if (originalMember != null) {
                joinDate = originalMember.getJoinDate(); // 기존 가입일 유지
            } else {
                joinDate = new Date(); // 만약 기존 정보가 없다면 현재 날짜 (이 경우는 거의 없음)
            }
            // 비밀번호가 입력되지 않았다면 기존 비밀번호 유지
            if (pwd == null || pwd.trim().isEmpty()) {
                if (originalMember != null) {
                    pwd = originalMember.getPwd();
                }
            }


            MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
            memberDAO.updateMember(memberVO);
            System.out.println("Controller: 회원 수정 처리 - " + id);
            response.sendRedirect(request.getContextPath() + "/member/listMembers.do");
            return;
        } else if (action.equals("/delMember.do")) {
            String id = request.getParameter("id");
            memberDAO.delMember(id);
            System.out.println("Controller: 회원 삭제 처리 - " + id);
            response.sendRedirect(request.getContextPath() + "/member/listMembers.do");
            return;
        } else {
            List<MemberVO> membersList = memberDAO.listMembers();
            request.setAttribute("membersList", membersList);
            nextPage = "/test01/listMembers.jsp";
        }

        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
        dispatch.forward(request, response);
    }
}
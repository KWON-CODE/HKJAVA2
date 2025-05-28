package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; // java.util.List로 수정

public class MemberDAO {
    // 데이터베이스 접속 정보 (실제 환경에 맞게 수정하세요)
    private static final String driver = "oracle.jdbc.driver.OracleDriver"; // 예: Oracle
    private static final String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 예: Oracle (SID가 XE인 경우)
    private static final String user = "scott"; // DB 사용자 아이디
    private static final String pwd = "tiger";  // DB 사용자 비밀번호

    private Connection con;
    private Statement stmt;

    public List<MemberVO> listMembers() {
        List<MemberVO> list = new ArrayList<>(); // 제네릭 명시
        try {
            connDB();
            String query = "select * from t_member";
            System.out.println("실행 쿼리: " + query);
            ResultSet rs = stmt.executeQuery(query); // rSet -> rs 또는 rs -> rSet으로 통일
            while (rs.next()) {
                String id = rs.getString("id");
                String dbPwd = rs.getString("pwd"); // pwd 변수명이 클래스 멤버 pwd와 겹치므로 변경
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPwd(dbPwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                list.add(vo);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private void connDB() {
        try {
            Class.forName(driver);
            System.out.println(driver + " 드라이버 로딩 성공");
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connection 생성 성공");
            stmt = con.createStatement();
            System.out.println("Statement 생성 성공");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
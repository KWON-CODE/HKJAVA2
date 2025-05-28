//문장통 2 가지
//1. createStatement() 빈통 => ? 파라메타 없이 빈통 만들때 사용
//2. preparedStatement() 준비된통 => ?파라미터 있을때 사용

// 문장통(Statement()을 실행 2가지) 
// 1. executeQuery() => select
// => ResultSet 통 : select로 조회된 결과물을 저장하는 통
// 2. executeUpdate() => insert, update, delete

// 실습) 
// createStatement() == > 파라미터 없이 빈통
// executeQuery(sqlSelect) =>
 // 문장통 실행시에 2가지 
			 //1. executeUpdate() : insert, update, delete
			 //2.  executeQuery() : select

package a250407;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class testUpdate extends JDBCString {

	
	public static void main(String[] args) {
		try {
			Class.forName(driver); // 드라이버 가져오기
			Connection conn = DriverManager.getConnection(url,user, password); // 2)연결하기
			PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
			Scanner sc= new Scanner(System.in);
			
			System.out.println("이름 입력");
			pstmt.setString(2, sc.next());
			
			System.out.println("수정할 비밀번호 입력");
			pstmt.setString(1, sc.next());
//			
//			pstmt.setString(2, "홍길동");
//			pstmt.setString(1, "9999");
			int re= pstmt.executeUpdate();
			if (re == 1) System.out.println("성공");
			else System.out.println("실패");

			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

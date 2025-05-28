package a250407;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class proUpdate extends proJDBCString {

	public static void main(String[] args) {
		try {
			Class.forName(driver); // 드라이버 가져오기
			Connection conn = DriverManager.getConnection(url,user, password); // 2)연결하기
			PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
			Scanner sc= new Scanner(System.in);
			
			System.out.println("수정할 이메일 입력");
			pstmt.setString(1, sc.next());
			
			System.out.println("코드 입력");
			pstmt.setString(2, sc.next());	
			
			int re= pstmt.executeUpdate();
			if (re == 1) System.out.println("성공");
			else System.out.println("실패");

			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

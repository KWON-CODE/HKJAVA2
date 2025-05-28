package a250407;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class proInsert extends proJDBCString {

	public static void main(String[] args) {
		try {
			Class.forName(driver); // 드라이버 가져오기
			Connection conn = DriverManager.getConnection(url,user, password); // 2)연결하기
			conn.prepareStatement(sqlInsert);
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("코드=");
			pstmt.setString(1, sc.nextLine());
			
			System.out.println("이름=");
			pstmt.setString(2, sc.nextLine());
			
			System.out.println("이메일=");
			pstmt.setString(3, sc.nextLine());
			
			System.out.println("전화번호=");
			pstmt.setString(4, sc.nextLine());
			
			int re = pstmt.executeUpdate();
			if (re == 1) System.out.println("OK");
			else System.out.println("실패");


		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}

}

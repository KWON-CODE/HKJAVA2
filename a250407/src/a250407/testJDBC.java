package a250407;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class testJDBC extends JDBCString {
	
	public static void main(String[] args) {
		
		try {
			Class.forName(driver); // 드라이버 가져오기
			Connection conn = DriverManager.getConnection(url,user, password); // 2)연결하기
			 Statement stmt = conn.createStatement(); //3) 문장통만들기
			// stmt.set
			System.out.println("OK");
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

}

package a250407;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class proSelect extends proJDBCString {

	public static void main(String[] args) {
		try {
			Class.forName(driver); // 드라이버 가져오기
			Connection conn = DriverManager.getConnection(url,user, password); // 2)연결하기
			Statement stmt = conn.createStatement(); //3) 문장통만들기
			ResultSet rs= stmt.executeQuery(sqlSelect);
			
			System.out.println("CODE\tNAME\tEMAIL\tTEL");
	        System.out.println("----------------------------------------");
			
			while(rs.next()) {
				System.out.println(
		                rs.getString("code") + "\t" +
		                rs.getString("name") + "\t" +
		                rs.getString("email") + "\t" +
		                rs.getString("tel") + "\t" 
		            );
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

}

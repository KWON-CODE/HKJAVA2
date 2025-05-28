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

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testSelect extends JDBCString {

	
	public static void main(String[] args) {
		try {
			Class.forName(driver); // 드라이버 가져오기
			Connection conn = DriverManager.getConnection(url,user, password); // 2)연결하기
			Statement stmt = conn.createStatement(); //3) 문장통만들기
			ResultSet rs= stmt.executeQuery(sqlSelect);
			
			System.out.println("CODE\tNAME\tID\tPWD\tAGE");
	        System.out.println("----------------------------------------");
			
			while(rs.next()) {
				System.out.println(
		                rs.getString("code") + "\t" +
		                rs.getString("name") + "\t" +
		                rs.getString("id") + "\t" +
		                rs.getString("pwd") + "\t" +
		                rs.getString("age")
		            );
//				System.out.println(rs.getString(1)  + "\t");
//				System.out.println(rs.getString(2) + "\t");
//				System.out.println(rs.getString(3) + "\t");
//				System.out.println(rs.getString(4)+ "\t");
//				System.out.println(rs.getString(5));
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}

}

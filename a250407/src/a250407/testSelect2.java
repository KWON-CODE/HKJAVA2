package a250407;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class testSelect2 extends JDBCString{
    public static void main(String[] args) {
        String sqlSelect="select  name,   id,   pwd  from  member  where  name like '%";
        try {
            Class.forName(driver);  //드라이버를 메모리로 로딩
            conn=DriverManager.getConnection(url, user, password); //드라이버연결(오라클,유저,비번) 

            Scanner sc=new Scanner(System.in);  //입력장치(콘솔)

            System.out.println("검색할 이름을 입력하세요");
            String name=sc.nextLine();
            name=sqlSelect+name+"%'";
            pstmt=conn.prepareStatement(name);

            //pstmt.setString(1, name);    //콘솔입력장치로부터 문자열입력(nextLine)

            ResultSet rs=pstmt.executeQuery();    //쿼리실행후 ResultSet(결과통) rs에 저장 
            while(rs.next()) {                    //rs의 결과중 한줄씩(next)읽어오기
                System.out.print(rs.getString(1)+"\t");   //rs.getString(1) 은 rs의 첫번째필드 가져옴
                System.out.print(rs.getString(2)+"\t");
                System.out.println(rs.getString(3));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




//package a250407;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Scanner;
//
//public class testSelect2 extends JDBCString {
//	public static void main(String[] args) {
//		// String sqlSelect2="select name, id, pwd from member where name=?";
//		String sqlSelect2="select name, id, pwd from member where name like '%'";
//		
//		try {
//		Class.forName(driver); // 드라이버를 메모리로 로딩
//		Connection conn = DriverManager.getConnection(url,user, password); // 2) 드라이버 연결하기
//		PreparedStatement pstmt = conn.prepareStatement(sqlSelect2);
//		pstmt= conn.prepareStatement(sqlSelect2);
//		
//		Scanner sc= new Scanner(System.in); // 입력장치(콘솔)
//		
//		
//		System.out.println("검색할 이름을 입력하세요");
//		String name = sc.nextLine();
//		name= sqlSelect2 + name + "'%'";
//		pstmt= conn.prepareStatement(name);
//		
//		//pstmt.setNString(1, sc.nextLine()); // 콘솔입력장치로부터 문자열입력(nextline)
//		
//		
//		ResultSet rs= pstmt.executeQuery(); // 쿼리 실행후 ResultSet(결과물) rs에 저장
//		
//		while(rs.next()) { // rs의 결과물 한줄씩 읽어오기
//			
//			System.out.println(
//								rs.getString(1) + "\t" +
//				                rs.getString(2) + "\t" +
//				                rs.getString(3) + "\t");
////			System.out.println(rs.getString(1)  + "\t"); // rs.getString(1)은 rs의 첫번째 필드 가져옴
////			System.out.println(rs.getString(2) + "\t");
////			System.out.println(rs.getString(3) + "\t");
//		}
//		
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	
//}
//}
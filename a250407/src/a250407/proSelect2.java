package a250407;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class proSelect2 extends proJDBCString {

	public static void main(String[] args) {
		String sqlSelect="select * from customer where name like '%";
        try {
            Class.forName(driver);  //드라이버를 메모리로 로딩
            conn=DriverManager.getConnection(url, user, password); //드라이버연결(오라클,유저,비번) 

            Scanner sc=new Scanner(System.in);  //입력장치(콘솔)

            System.out.println("검색할 이름을 입력하세요");
            String name=sc.nextLine();
            name=sqlSelect+name+"%'";
            pstmt=conn.prepareStatement(name);

            //pstmt.setString(1, name);    //콘솔입력장치로부터 문자열입력(nextLine)
            
            System.out.println("CODE\tNAME\tEMAIL\tTEL");
	        System.out.println("----------------------------------------");

            ResultSet rs=pstmt.executeQuery();    //쿼리실행후 ResultSet(결과통) rs에 저장 
            while(rs.next()) {                    //rs의 결과중 한줄씩(next)읽어오기
                
                System.out.println(rs.getString("code") + "\t" +
		                rs.getString("name") + "\t" +
		                rs.getString("email") + "\t");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}

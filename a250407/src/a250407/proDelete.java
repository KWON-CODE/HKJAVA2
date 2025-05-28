package a250407;

import java.sql.DriverManager;
import java.util.Scanner;

public class proDelete extends proJDBCString {

	public static void main(String[] args) {
		try {
            Class.forName(driver);   //1) 드라이버를 가져오기
            conn=DriverManager.getConnection(url, user, password); //2)연결하기
            pstmt=conn.prepareStatement(sqlDelete);
            Scanner sc=new Scanner(System.in);

            System.out.println("삭제할 코드를 입력하세요");
            pstmt.setString(1, sc.nextLine());

            int re=pstmt.executeUpdate();
            if (re==1) System.out.println("삭제성공");
            else System.out.println("삭제실패");

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}

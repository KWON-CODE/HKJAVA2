package a250414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BufferedStreamTest {

	public static void main(String[] args) {
		try {
			System.out.println("당신의 이름을 입력하세요");
			   // 1번방법
//				InputStreamReader in = new InputStreamReader(System.in);
//			   	BufferedReader br= new BufferedReader(in); ==
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			   String name = br.readLine();
			   
			   // 2번방법
			   System.out.println("당신의 주소를 입력하세요");
			   Scanner sc= new Scanner(System.in);
			   String juso = sc.nextLine();
			   
			   System.out.println("당신의 이름은 =" + name);
			   System.out.println("당신의 주소는 =" + juso);
//			   char str = (char) in.read();
//			   System.out.println((char) in.read());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

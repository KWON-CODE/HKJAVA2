package a250414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BufferedStreamTest {

	public static void main(String[] args) {
		try {
			System.out.println("����� �̸��� �Է��ϼ���");
			   // 1�����
//				InputStreamReader in = new InputStreamReader(System.in);
//			   	BufferedReader br= new BufferedReader(in); ==
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			   String name = br.readLine();
			   
			   // 2�����
			   System.out.println("����� �ּҸ� �Է��ϼ���");
			   Scanner sc= new Scanner(System.in);
			   String juso = sc.nextLine();
			   
			   System.out.println("����� �̸��� =" + name);
			   System.out.println("����� �ּҴ� =" + juso);
//			   char str = (char) in.read();
//			   System.out.println((char) in.read());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

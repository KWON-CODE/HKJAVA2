package a250414;

// DataOutputStream 자료형 그대로 전달시 사용
// 
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileDataOutputTest {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream out = null;
		Scanner sc=new Scanner(System.in);
		try {
			out = new DataOutputStream(new FileOutputStream("testout.txt"));
			System.out.println("이름을 입력하세요  예 : 홍길동");
			out.writeUTF(sc.nextLine());
			System.out.println("이름을 입력하세요  예 : 홍길동");
			out.writeInt(sc.nextInt());
			System.out.println("이름을 입력하세요  예 : 홍길동");
			out.writeDouble(sc.nextDouble());
//			out.writeUTF("홍길동");
//			out.writeInt(18);
//			out.writeDouble(165.5);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}

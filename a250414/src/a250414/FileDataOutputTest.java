package a250414;

// DataOutputStream �ڷ��� �״�� ���޽� ���
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
			System.out.println("�̸��� �Է��ϼ���  �� : ȫ�浿");
			out.writeUTF(sc.nextLine());
			System.out.println("�̸��� �Է��ϼ���  �� : ȫ�浿");
			out.writeInt(sc.nextInt());
			System.out.println("�̸��� �Է��ϼ���  �� : ȫ�浿");
			out.writeDouble(sc.nextDouble());
//			out.writeUTF("ȫ�浿");
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

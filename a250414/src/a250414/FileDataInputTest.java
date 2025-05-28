package a250414;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileDataInputTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream in = null;
		try {
			fis = new FileInputStream("testout.txt");
			in = new DataInputStream(fis);
			 String  name= in.readUTF();
			 int age = in.readInt();
			 double height = in.readDouble();
			 System.out.println("�̸�=" + name);
			 System.out.println("����=" + age);
			 System.out.println("Ű=" + height);
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				}
		}
	}
}

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
			 System.out.println("이름=" + name);
			 System.out.println("나이=" + age);
			 System.out.println("키=" + height);
			 
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

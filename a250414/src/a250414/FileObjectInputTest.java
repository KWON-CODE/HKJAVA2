package a250414;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class FileObjectInputTest {

	public static void main(String[] args) {
		FileInputStream fis=null;
		ObjectInputStream in = null;
		try {
			fis= new FileInputStream("testObject.txt");
			in = new ObjectInputStream(fis);
			String name = in.readObject().toString();
			int age = (int) in.readObject();
			double height = (double) in.readObject();
			
			System.out.println("이름 :" + name);
			System.out.println("나이 :" + age);
			System.out.println("키 :" + height);
//			System.out.println(in.readObject());
//			System.out.println(in.readObject());
//			System.out.println(in.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

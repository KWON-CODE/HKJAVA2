package a250414;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileObjectOutputTest {

	public static void main(String[] args) {
		FileOutputStream fos=null;
		ObjectOutputStream out = null;
		
		try {
			fos = new FileOutputStream("testObject.txt");
			out = new ObjectOutputStream(fos);
			out.writeObject("ȫ�浿");
			out.writeObject(18);
			out.writeObject(165.5);
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

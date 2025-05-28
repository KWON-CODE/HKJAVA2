package a250414;

import java.io.FileReader;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader file=null;
		try {
//			File filename = new File("test1.txt");
			file = new FileReader("test1.txt"); // test1.txt 대신 filename 가능
			int ch;
			while((ch = file.read())!=-1) {
				System.out.println((char) ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

// sample.txt에서 바이트 단위씩(한개씩) read하는 프로그램

package a250414;

import java.io.FileInputStream;

public class IOTest02 {

	public static void main(String[] args) {
		FileInputStream fis= null;
		try {
			//File file = new File("sample.txt");
			fis= new FileInputStream("sample.txt");
			int ch;
			while((ch=fis.read())!=-1) {
				System.out.print((char) ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

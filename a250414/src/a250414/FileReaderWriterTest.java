package a250414;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//sample.txt 의 모든 문자를 읽어와서 test2.txt로 저장하는 프로그램 완성
// 결국 sample.txt외 동일한 내용의 test2.txt 만드는 프로그램

public class FileReaderWriterTest {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("복사할 원본 파일명을 입력하시오");
		File filein= new File(sc.next());
		
		System.out.println("대상 파일명을 입력하시오");
		File fileout= new File(sc.next());
		
//		File filein = new File("sample.txt");
//		File fileout = new File("test2.txt");
//		
		FileReader in = null;
		FileWriter out = null;
		int ch;
		try {
			in = new FileReader(filein);
			out = new FileWriter(fileout);
			while ((ch=in.read())!=-1) {
				out.write((char) ch);
			}
			} catch (Exception e) {
				e.printStackTrace();			
			}
		 finally {
			try {
				in.close();
				out.close();
			
			}catch (Exception e2) {
				e2.printStackTrace();
			}
	}

}
}

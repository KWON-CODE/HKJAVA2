package a250414;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//sample.txt �� ��� ���ڸ� �о�ͼ� test2.txt�� �����ϴ� ���α׷� �ϼ�
// �ᱹ sample.txt�� ������ ������ test2.txt ����� ���α׷�

public class FileReaderWriterTest {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("������ ���� ���ϸ��� �Է��Ͻÿ�");
		File filein= new File(sc.next());
		
		System.out.println("��� ���ϸ��� �Է��Ͻÿ�");
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

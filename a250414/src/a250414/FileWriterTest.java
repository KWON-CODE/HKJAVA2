package a250414;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileWriterTest {

	public static void main(String[] args) {
		FileWriter file =null;
		try {
//			File filename = new File("test1.txt");
			file = new FileWriter("test1.txt"); // "test1.txt" ��� filename ����
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String name = in.readLine();
			String juso = in.readLine();
			
			file.write("�̸� :" + name + "\r\n");
			file.write("�ּ� :" + juso + "\r\n");

			//file.write('A');
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}

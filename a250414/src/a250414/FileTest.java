package a250414;
// File() ���ϰ�ü�� ���� ���� �˾ƺ���
import java.io.File;
import java.sql.Date;

public class FileTest {

	public static void main(String[] args) {
		 File file= new File("sample.txt");
		 System.out.println("�����̳�?" + file.isFile());
		 System.out.println("���丮��?" + file.isDirectory());
		 System.out.println("�̸�?" + file.getName());
		 System.out.println("������?" + file.getAbsolutePath());
		 System.out.println("�ֱ� ������?" + new Date(file.lastModified()));
		 System.out.println("ũ��?" + file.length());

	}

}

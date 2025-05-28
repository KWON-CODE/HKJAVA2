package a250414;
// File() 파일객체에 대한 정보 알아보기
import java.io.File;
import java.sql.Date;

public class FileTest {

	public static void main(String[] args) {
		 File file= new File("sample.txt");
		 System.out.println("파일이냐?" + file.isFile());
		 System.out.println("디렉토리냐?" + file.isDirectory());
		 System.out.println("이름?" + file.getName());
		 System.out.println("절대경로?" + file.getAbsolutePath());
		 System.out.println("최근 수정일?" + new Date(file.lastModified()));
		 System.out.println("크기?" + file.length());

	}

}

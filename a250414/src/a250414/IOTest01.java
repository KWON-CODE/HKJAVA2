// 알파벳을 sample.txt에 바이트단위씩(한개씩) write하는 프로그램//

// 소켓 파일
//-------------------(1)바이트 객체------------------------------
//FileInputStream("파일명") : 파일입력 (바이트 단위)
// FileOutputStream("파일명") : 파일 출력(바이트 단위)
//------------------2(문자객체)-------------------
// FileWriter("파일명") : 파일출력(문자단위)
// FileReader("파일명") : 파일입력(문다단위)
//------------3.바이너스 형태의 객체---------------------------------
//DataInputStream(바이트객체) : 파일 입력(기본자료형태로 전달 ex.int ,double, boolean)
//DataOutputStream(바이트객체) : 파일 출력(기본자료형태로 전달)
//-------------4.바이너스 형태의 객체 ------------------------------------
//ObjectInputStream(바이트객체) : 파일입력(기본자료형태로 전달 Object)
//ObjectOutputStream(바이트객체) : 파일 출력(기본자료형태로 전달)

package a250414;

import java.io.FileOutputStream;
import java.sql.ClientInfoStatus;

public class IOTest01 {

	public static void main(String[] args) {
		FileOutputStream fos = null; // 바이트단위
		try {
			// File file= new File("sample.txt");
			fos =new FileOutputStream("sample.txt", true);
			System.out.println("현재 작업 디렉토리: " + System.getProperty("user.dir"));
		for(int i='A'; i<='Z';i++) {
			fos.write(i);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
			} catch (Exception e) {

			}
		}
	}

}

package a250414;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientText {

	public static void main(String[] args) {
		Socket socket=null;
		System.out.println("클라이언트 구현");
		System.out.println("-------------------------------------------------");
		try {
			socket= new Socket("192.168.2.198", 9007);
			
			BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입력스트림
			PrintWriter out	 =	new PrintWriter(socket.getOutputStream()); // 출력스트림
			
			out.println("안녕하세요 192.168.2.49");
			out.flush(); // 버퍼에서 보내짐
			
			
			String str=in.readLine();	
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}
	}

}

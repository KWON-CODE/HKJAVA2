package a250414;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// 클라이언트 채팅구현
public class ClientByte {

	public static void main(String[] args) {
		Socket socket=null;

		try {
			socket= new Socket("192.168.2.198", 9000);
			
			InputStream in= socket.getInputStream(); // 입력스트림
			OutputStream out= socket.getOutputStream(); // 출력스트림
			
			String str = "안녕하세요 192.168.2.49";
			out.write(str.getBytes());
			
			byte arr[] = new byte[100]; 
			in.read(arr); // 상대방이 보낸글자를 읽어서 => arr배열로 저장
			System.out.println(new String(arr));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

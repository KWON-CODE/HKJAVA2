package a250414;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 서버 채팅구현
public class ServerByte {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket = null; 
		try {
			serverSocket=new ServerSocket(9000);
			socket= serverSocket.accept();
			while(true) {
				
			InputStream in= socket.getInputStream(); // 입력스트림
			OutputStream out= socket.getOutputStream(); // 출력스트림
			
			byte arr[] = new byte[100]; 
			in.read(arr); // 상대방이 보낸글자를 읽어서 => arr배열로 저장
			System.out.println(new String(arr));
			String str= "서버가 보낸메시지 : 자료 잘받음";
			out.write(str.getBytes());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

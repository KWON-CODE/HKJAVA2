package a250414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerText {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket = null; 
		System.out.println("서버 구현");
		System.out.println("=================================");
		
		try {
			serverSocket=new ServerSocket(9001);
			
			while(true) {
			socket= serverSocket.accept();
			BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입력스트림
			PrintWriter out	 =	new PrintWriter(socket.getOutputStream()); // 출력스트림
			
			out.flush();
			String str = in.readLine();
			System.out.println(str);
			
			
			out.println("고객님 안녕하세요 저는 서버입니다.");
			out.flush(); // 버퍼에서 보내짐
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				socket.close();
				serverSocket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

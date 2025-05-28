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
		System.out.println("���� ����");
		System.out.println("=================================");
		
		try {
			serverSocket=new ServerSocket(9001);
			
			while(true) {
			socket= serverSocket.accept();
			BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream())); // �Է½�Ʈ��
			PrintWriter out	 =	new PrintWriter(socket.getOutputStream()); // ��½�Ʈ��
			
			out.flush();
			String str = in.readLine();
			System.out.println(str);
			
			
			out.println("���� �ȳ��ϼ��� ���� �����Դϴ�.");
			out.flush(); // ���ۿ��� ������
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

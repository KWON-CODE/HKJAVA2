package a250414;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// ���� ä�ñ���
public class ServerByte {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket = null; 
		try {
			serverSocket=new ServerSocket(9000);
			socket= serverSocket.accept();
			while(true) {
				
			InputStream in= socket.getInputStream(); // �Է½�Ʈ��
			OutputStream out= socket.getOutputStream(); // ��½�Ʈ��
			
			byte arr[] = new byte[100]; 
			in.read(arr); // ������ �������ڸ� �о => arr�迭�� ����
			System.out.println(new String(arr));
			String str= "������ �����޽��� : �ڷ� �߹���";
			out.write(str.getBytes());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

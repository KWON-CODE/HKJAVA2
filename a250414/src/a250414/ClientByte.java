package a250414;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// Ŭ���̾�Ʈ ä�ñ���
public class ClientByte {

	public static void main(String[] args) {
		Socket socket=null;

		try {
			socket= new Socket("192.168.2.198", 9000);
			
			InputStream in= socket.getInputStream(); // �Է½�Ʈ��
			OutputStream out= socket.getOutputStream(); // ��½�Ʈ��
			
			String str = "�ȳ��ϼ��� 192.168.2.49";
			out.write(str.getBytes());
			
			byte arr[] = new byte[100]; 
			in.read(arr); // ������ �������ڸ� �о => arr�迭�� ����
			System.out.println(new String(arr));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// ���ĺ��� sample.txt�� ����Ʈ������(�Ѱ���) write�ϴ� ���α׷�//

// ���� ����
//-------------------(1)����Ʈ ��ü------------------------------
//FileInputStream("���ϸ�") : �����Է� (����Ʈ ����)
// FileOutputStream("���ϸ�") : ���� ���(����Ʈ ����)
//------------------2(���ڰ�ü)-------------------
// FileWriter("���ϸ�") : �������(���ڴ���)
// FileReader("���ϸ�") : �����Է�(���ٴ���)
//------------3.���̳ʽ� ������ ��ü---------------------------------
//DataInputStream(����Ʈ��ü) : ���� �Է�(�⺻�ڷ����·� ���� ex.int ,double, boolean)
//DataOutputStream(����Ʈ��ü) : ���� ���(�⺻�ڷ����·� ����)
//-------------4.���̳ʽ� ������ ��ü ------------------------------------
//ObjectInputStream(����Ʈ��ü) : �����Է�(�⺻�ڷ����·� ���� Object)
//ObjectOutputStream(����Ʈ��ü) : ���� ���(�⺻�ڷ����·� ����)

package a250414;

import java.io.FileOutputStream;
import java.sql.ClientInfoStatus;

public class IOTest01 {

	public static void main(String[] args) {
		FileOutputStream fos = null; // ����Ʈ����
		try {
			// File file= new File("sample.txt");
			fos =new FileOutputStream("sample.txt", true);
			System.out.println("���� �۾� ���丮: " + System.getProperty("user.dir"));
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

package a250414;

public class ByteStreamTest {

	public static void main(String[] args) {
		
		try {
			int data;
//			data = System.in.read(); // ����Ʈ �Է�(�ѱ��ڸ�)
//			System.out.println(data);
//			System.out.println((char) data);
			 
			while((data=System.in.read())!=-1) {
				System.out.print((char) data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

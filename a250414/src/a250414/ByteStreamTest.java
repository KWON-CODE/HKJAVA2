package a250414;

public class ByteStreamTest {

	public static void main(String[] args) {
		
		try {
			int data;
//			data = System.in.read(); // 바이트 입력(한글자만)
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

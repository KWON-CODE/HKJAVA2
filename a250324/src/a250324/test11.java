package a250324;

// 배열과 ArrayList의 차이점
//
import java.util.ArrayList;

public class test11 {
	
	
	public static void prn(ArrayList<Integer> c) {
		for (int i=0;i<c.size();i++) {
			System.out.println(c.get(i));
		}// c.get(0), c.get(1), c.get(2) 가져와서 출력
	}

	public static void main(String[] args) {
		int a[] = new int[10]; //배열 //a.length() 길이정보 알 수 있음
		int b[] = {10,20,30};
		ArrayList<Integer> c = new ArrayList<Integer>(); // c배열 c.size() 길이정보 알 수 있음
		c.add(10);
		c.add(20);
		c.add(30);
		
//		for (int i=0;i<c.size();i++) {
//			System.out.println(c.get(i));
//		}
		
		prn(c);
	}

}

package a250325;

import java.util.ArrayList;

// ArrayList 클래스 -- 배열용도로 사용

public class test2 {

	public static void prn (ArrayList<Integer> c) {
		System.out.println("-----------------------");
		for (int i=0;i<c.size();i++) {
		System.out.println(c.get(i));
	}
	}
	
	public static void prn2 (ArrayList<Integer> c) {
		System.out.println("-----------------");
		for (Integer temp : c) {
			System.out.println(temp);
		}
	}
	public static void main(String[] args) {
//		int a[] = new int[10];
//		int b[] = {10,90,30};
		ArrayList<Integer> c= new ArrayList<Integer>();
		c.add(100); //c 배열에 100 추가
		c.add(90);	//c 배열에 90추가
		c.add(80);
		prn2(c);
		System.out.println("-----------------------");
		
		c.set(1, 20);
		c.set(2, 99);
		prn(c);
		System.out.println("-------------------");
		c.remove(2); // c배열에 2번째 위치값을 제거
		prn(c);
		
		prn2(c);
//		  System.out.println(c.get(0)); System.out.println(c.get(1));
//		  System.out.println(c.get(2));

	}

}

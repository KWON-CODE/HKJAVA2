package a250325;

//Vector : ArrayList와 비슷

import java.util.Vector;
//import java.util.Objects;

public class test3 {

	
	public static void prn(Vector<Integer> a) {
		for (Integer temp: a) {
			System.out.println(temp);
		}
	}
	
	
	public static void main(String[] args) {
		Vector<Integer> a = new Vector<Integer>(4,3); // 총4개할당 3개씩 증가
		a.add(100);
		a.add(200);
		a.add(50);
		a.add(60);
		a.add(70);
		System.out.println("값할당된사이즈="+a.size());
		System.out.println("확보된메모리사이즈"+a.capacity());
		prn(a);
	}

}

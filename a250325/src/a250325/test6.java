package a250325;
// 클래스급 -- new 클래스()
// 인터페이스급(양부모) -- new 사용불가


import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

// Iterator 인터페이스 : 순차적으로 하나씩 접근하기 할때 사용
// Enumeration 인터페이스 : 


public class test6 {

	public static void prn2(Vector<String> vec) {
		Iterator<String> item=vec.iterator();
		System.out.println("-------------------------");
		while(item.hasNext()) {
			System.out.println(item.next());
		}
	}
	
	public static void prn3 (Vector<String> vec) {
		Enumeration<String> eitem=vec.elements();
		System.out.println("---------------------");
		while(eitem.hasMoreElements()) {
			System.out.println(eitem.nextElement());
		}
	}
	
	public static void prn(Vector<String> vec) {
		for(String temp : vec) {
			System.out.println(temp);
		}
	}
	
	public static void main(String[] args) {
		String a[]={"진달래", "백합", "개나리", "튤립", "장미"};
		
		Vector<String> vec = new Vector<String>();
		for (int i=0;i<a.length;i++) {
			vec.add(a[i]);
		}
		prn(vec);
		
		
		prn2(vec);
		prn3(vec);
		
		
	}

}

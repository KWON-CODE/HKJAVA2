package a250325;

// 구조체 클래스 ArrayList , Vector, LinkedList , Stack
import java.util.LinkedList;

// LinkedList : FIFO 구조 메모리가 인접하지 않을수도 있다.
// offer():입력, poll():출력

public class test5 {

	public static void prn(LinkedList<Integer> a) {
		System.out.println("-------------------------");
		
		for(Integer temp: a) {
			System.out.println(temp);
		}
		
		System.out.println("--------------------");
		while(!a.isEmpty()) {
			System.out.println(a.poll());
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.add(100);
		a.offer(20);
		a.offer(30);
		a.offer(40);
		
		prn(a);
	}

}

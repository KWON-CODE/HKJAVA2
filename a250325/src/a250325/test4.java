
/*// ArrayList, Vector 클래스 : FIFO 구조 (FIRST IN FIRST OUT) 
// -- ADD, SET, GET
*/


/*//Stack 클래스 
//리포 구조 LIFO구조 마지막으로 입력된 값이 먼저 나온다 EX)이전페이지
// LAST IN FIRST OUT
*/
//STACK 의 동작은 PUSH, POP
package a250325;

import java.util.Stack;

public class test4 {

	public static void prn(Stack<Integer> a) {
		
		while(!a.isEmpty()) {
			System.out.println(a.pop());
		}
//		for (Integer temp: a) {
//			System.out.println(temp);
//			}
	}
	
	public static void main(String[] args) {
		Stack<Integer> a = new Stack<Integer>();
		a.add(100);
		a.push(20);
		a.push(30);
		a.push(40);
		
		prn(a);
	}

}

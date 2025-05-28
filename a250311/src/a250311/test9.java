package a250311;
//다중 for문
//구구단 2단-9단 출력
public class test9 {

	public static void main(String[] args) {
		int a=0, b=0, c=0;
		for(a=2;a<=9;a++) {
			for(b=1;b<=9;b++) {
				c=a*b;
				System.out.println(a+"*"+b+"="+c);
			}
		}
	}

}

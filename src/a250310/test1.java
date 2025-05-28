package a250310;
//int정수, double실수, char문자, string문자
//4바이트,  8바이트,     1바이트,  무한
public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a,b,c,d; //a,b,c,d변수는 실수행이다.
		a=10.5;	//소수점이 있는 값은 double행 (8바이트)
		b=3;	//소수점이 없는 경우 int행(4바이트)
		c=a+b;
		d=a/b;
		System.out.println("c="+c);
		System.out.println("d="+d);
		
		char ch1='a';
		char ch2='1';
		char ch3='a';
		char ch4=' ';
		//char name='홍길동'; x(char에 부적합)
		String name2="홍길동";
		System.out.println(ch1);
		System.out.println(name2);
		System.out.printf("%d\n", (int) ch1);
		System.out.printf("%d\n", (int) ch2);
		System.out.printf("%d\n", (int) ch3);
		System.out.printf("%d\n", (int) ch4);
	}

}

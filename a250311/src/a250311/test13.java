package a250311;

//메소드(함수)
// 자료형 : int, double, char, String, boolean, void
//int =자료형 a()= a메소드 {}
// 자료형 메소드명(전달파라미터)
public class test13 {
	static void sum () {
		//return 0; void리턴값이 없어서 입력하면 안됨
		int a;
		int hap=0;
		for(a=1;a<=100;a++) {
			hap=hap+a;
		}
		System.out.println(hap);
	}
	static void sum(int a, int b) {
		int i, hap=0;
		for(i=a;i<=b;i++) {
			hap=hap+i;
		}
		System.out.println(hap);
	}
	
	static int sum(int a) {
		int i, hap=0;
		for(i=1;i<=a;i++) {
			hap=hap+i;
		}
		return 0;
	}
	
	public static void main(String[] args) { // 메인이 static이라서 sum도 static으로 지정
		sum(); // 컨트롤 키를 누른채로 클릭하면 함수를 찾아간다.
		sum(10,20);
	  int x = sum(200);
	  System.out.println(x);
	}

}

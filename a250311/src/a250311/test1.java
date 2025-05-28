package a250311;

// 네개의 수 a,b,c,d 중 가장큰 수를 출력하시오
// 또는 가장 작은수
// 조건 연산자
public class test1 {

	public static void main(String[] args) {
		int a=10, b=20, c=30, d=40, max=-999;
		max=(a>max)?a:max;
		max=(b>max)?b:max;
		max=(c>max)?c:max;
		max=(d>max)?d:max;
		
		System.out.println(max);
	}

}

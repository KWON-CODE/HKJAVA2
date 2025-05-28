package a250311;

//네개의 수 a,b,c,d 중 가장큰 수를 출력하시오
//또는 가장 작은수
//조건 연산자

public class test2 {

	public static void main(String[] args) {
		int a=10, b=20, c=30, d=40, max=-999, min=999;
		if (a>max) max=a;
		if (b>max) max=b;
		if (c>max) max=c;
		if (d>max) max=d;
		if (a<min) min=a;
		if (b<min) min=b;
		if (c<min) min=c;
		if (d<min) min=d;
		
		System.out.println(max);
		System.out.println(min);
	}

}

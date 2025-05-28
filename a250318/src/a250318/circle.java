package a250318;

public class circle extends shape { //클래스 앞에 final 붙으면 상속 불가
	//public final class circle extends shape 사용하면 상속 불가
	private final int r=5; //반지름 변수앞엔 자료형 int, String같은
	// 변수 앞에 final 붙으면 값 변경 안됨
	public double area() {
		res=r*r*Math.PI;
		return res;
	}
}

class xcircle extends circle {
	
}
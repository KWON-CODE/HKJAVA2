package a250324;

abstract class shape {
	public int res=0;
	
	public abstract void draw(); // {}중괄호 사용불가 추상클래스에 나오는 추상메소드는 선언으로 끝난다.
	public void show() {
		System.out.println("그리다.");
	}
}

class circle extends shape {

	public void draw() {
		System.out.println("원 그리기");
	}
	
	public void show() {
		System.out.println("또 그리기");
	}
	
}

public class test2 {

	public static void main(String[] args) {
		// 추상클래스라 인스턴스 생성 불가shape s = new shape();

	}

}

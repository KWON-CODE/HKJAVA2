package a250324;

class point2 { //멤버변수와 멤버 메소드로 구성된 구조
	// 친부모자격 new 생성된다.
	public int p1, p2; // 멤버 변수
	public void show () { // 멤버메소드
		System.out.println(p1+","+p2);
	}
}

interface drawable { //멤버변수와 멤버 메소드로 구성된 구조
	// 클래스와의 차이점 : 클래스는 친부모 인터페이스는 양부모
	// 인터페이스는 new 사용불가 (생성능력 없음)
	// 양부모자격 new 생성 안됨 양부모는 값이 존재해야한다
	
	int x=10,y=20; //멤버변수 빈값이 안되고 값을 정의해야한다.
	public void draw ();
	
	
}

class circle2 extends point2 implements drawable {

	public void draw() {
		System.out.println("원그리기시작");
	}
	}


public class test3 {

	public static void main(String[] args) {
		point2 p = new point2();
		 //drawable d = new drawable(); 인터페이스는 뉴 사용 불가
		
		circle2 c= new circle2();
		c.draw();
		
		

	}

}

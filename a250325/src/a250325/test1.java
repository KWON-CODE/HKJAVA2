package a250325;

//인터페이스 : 멤버변수와 멤버 메소드로 구성된 구조 => 상속을 위해서 존재
//클래스 : 멤버변수와 멤버 메소드로 구성된 구조

interface color {
	public int red=1, green=2, blue=3;  // 인터페이스는 값을 대입해야한다
	// public int gray; // 이렇게 사용시 오류
	
	public void draw();
	//public abstract void draw(); // abstract 추상성질 : 선언하고 끝내야함
	//public void draw();
  //public void draw() {}; // 이렇게도 사용 불가
}

class point {
	public int x, y;
	public void show() {
		System.out.println(x);
		System.out.println(y);
	}
}

class circle extends point implements color{ // extends 는 클래스 implements는 인터페이스 인터페이스로 상속받았을땐

	@Override
	public void draw() { // 오버라이딩을 해야한다 
		System.out.println(color.red+"=빨간색");
		System.out.println(color.green+"=녹색");
		System.out.println(color.blue+"=파랑색");
	} 
	
}


public class test1 {
	
	public static void main(String[] args) throws Exception {
		try {
			circle kim=new circle();
			kim.draw();
			
			System.out.println(color.red);
			System.out.println(color.blue);
			System.out.println(color.green);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
}

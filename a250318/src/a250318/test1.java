package a250318;
// 객체 지향
// 클래스 : 붕어빵틀, 반죽, 팥 등등 재료와 만들기, 굽기, 진열등등 동작으로 구성된 구조
// 클래스 : 멤버변수(자료)와 멤버메소드(동작)으로 구성된 구조
// 객체 : 클래스를 통하여 생성된 결과물(객체)
// 상속 : 이전의 클래스를 상속 받아서 재사용 개념 (부모, 자식)

class point {
	public int x,y; // 멤버변수 this.x , this.y
	public static int z=100;
	
	public static void cal() {
		z=z+1;
	}
	
	public static void prn() {
		System.out.println(z);
	}
	
	public point() {
        this.x = 0;
        this.y = 0;
    }
	
	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	public void show() {
		System.out.println(x+","+y);
	}
}


public class test1 {

	public static void main(String[] args) {
		point a=new point();
		a.setX(10);
		a.setY(20);
		a.show();
		
		System.out.println(a.getX()+a.getY());
//		a.cal();
//		a.prn();
		point.cal();
		point.prn();
	}

}

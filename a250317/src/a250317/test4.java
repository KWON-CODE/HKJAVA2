package a250317;

//클래스란 멤버변수와 멤버메소드로 구성된 구조
// 클래스란 자료(재료)와 동작(행동)으로 구성된 형태
// get과 set의 차이
class point{
	int x, y;
	
	public void setX(int x) {
		this.x =x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}
	
	void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	void show() {
		System.out.println(x+","+y);
	}
}

public class test4 {

	public static void main(String[] args) {
		point a=new point();
		a.setX(10);
		a.setY(20);
		a.show();
		
		point p1= new point();
		p1.set(10, 5);
		p1.show();
		System.out.println(p1.getX()+p1.getY());
	}

	}


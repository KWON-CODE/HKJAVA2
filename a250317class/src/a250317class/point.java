package a250317class;

public class point {
	public int x,y;
	
	
//	// 생성자 메소드
//	public point() {
//		x=0;
//		y=0;
//	}
//	
//	public point(int x, int y) {
//		this.x=x;
//		this.y=y;
//	}

	
	public point(int x, int y) {
	this.x = x;
	this.y = y;
}

	public point() {
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

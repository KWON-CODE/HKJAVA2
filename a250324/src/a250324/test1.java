package a250324;
//클래스가 멤버변수와 멤버메소드로 구성된 구조


class point {
	// public final int x=10; // final 사용하면 불변
	public int x;
	public int y;
	
	public void show() {
		System.out.println(x+","+y);
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

	public point() {
		super();
	}

	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
 

class point3d extends point {
	public int z;
	
	public  point3d (int x, int y, int z)
	{
		super(x,y);
		this.z = z;
	}
	
	
	public point3d() {
		super();
		// TODO Auto-generated constructor stub
	}


	public point3d (int x, int y) {
		super(x, y);
	}
	public void show() {
		super.show(); // 부모의 show에 다녀와라
		System.out.println(z);
	}
}

public class test1 {

	public static void main(String[] args) {
		point p= new point();
		p.setX(10);
		p.setY(20);
		p.show();
		
		point p2=new point(100, 200);
		p2.show();
	}

}

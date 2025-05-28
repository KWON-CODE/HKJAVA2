package a250318;

public class point2d {
	public int x,y;
	
	public void show() {
		System.out.println(x+","+y);
	}
	
	public point2d (int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public point2d() {
		super();
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
}

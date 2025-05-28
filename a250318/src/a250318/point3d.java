package a250318;
// 오버라이딩 : 재정의; 덮어쓰기

public class point3d extends point2d {
	public int z;
	
	public void show() {
		super.show();
		System.out.println(z);
		
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public point3d() {
		super();
		// TODO Auto-generated constructor stub
	}

	public point3d(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public point3d(int x, int y, int z) {
		super(x, y);
		this.z = z;
		this.x = x;
		this.y = y;
	}
	
	
}


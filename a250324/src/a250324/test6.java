package a250324;


class outer2 {
	int outdata=100;
	public void xx() {
		
	}
	
	public int yy() {
		return 1;
	}
	
	public Object outermethod() {
		final int localdata=200;
		return (new Object() {
			public String toString() {
				return "내부메소드 연습:" + localdata;
			}		
		});
	}
}

public class test6 {

	public static void main(String[] args) {
		outer2 out = new outer2();
		Object obj= out.outermethod();
		System.out.println(obj.toString());
	}

}

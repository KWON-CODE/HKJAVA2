package a250324;

class outer {
	static int outdata=100;
	public static void show() {
		System.out.println("---------------");
	}
	
	class inner {
		int indata=200;
		public void print() {
			System.out.println(outdata);
			show();
		} 
	}
}


public class test4 {

	public static void main(String[] args) {
//		outer out= new outer();
//		outer.inner in= out.new inner();
//		in.print();
		outer.show();
	}

}

package a250317class;

public class Account {
	public int count;
	public static int total;
	
	public Account() { // 기본값 0
	}
	
	public void cal() {
		count=count+1;
		total=total+count;
	}
	public static void show() {
		System.out.println("합계="+total);
	}
}

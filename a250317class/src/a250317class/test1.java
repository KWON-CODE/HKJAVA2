package a250317class;

public class test1 {

	public static void main(String[] args) {
		point a= new point(); // new 사용해서 초기값
		a.show();
		
		point b=new point(700,200);
		b.show();
		b.setX(300);
		b.setY(200);
		b.show();
	}

}

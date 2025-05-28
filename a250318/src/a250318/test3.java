package a250318;

// 클래스에서의 형변환에 대해서
// int a =10;
// int a= 10.5; // 에러
// int a= (int) 10.5
/// ↑ 구식
//int a=4;
	// double b = a;
	//int c = (int) b; // 에러이므로 캐스트 연산자로 형변환 시킴
	//




public class test3 {
	

	public static void main(String[] args) {
		point3d pt= new point3d();
		pt.setX(10);
		pt.setY(20);
		pt.setZ(30);
		pt.show();
		
		point2d up=pt;
		System.out.println(up.x);
		System.out.println(up.y);
		// System.out.println(up.z);
		up.show();
		
		point3d down =(point3d) up; //에러 이므로 캐스트연산자로 형변환 시켜야함
	}

}

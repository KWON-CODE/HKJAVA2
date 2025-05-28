package a250318;


 ///오버라이딩 재정의
public class test4  //extends Object // 기본으로 object가 부모클래스로 설정되어있어 생략가능

{
	// 부모가 누군지 모르면 최상위 부모 object 사용하면됨 public static void polymethod(Object ref)
	public static void polymethod(shape ref) {
		if(ref instanceof circle) {
			circle c=(circle) ref;
			System.out.println("원넓이="+c.area());
		}
		if(ref instanceof triangle) {
			triangle t=(triangle) ref;
			System.out.println("삼각형넓이="+t.area());
				}
		if(ref instanceof rectangle) {
			rectangle r=(rectangle) ref;
			System.out.println("사각형넓이="+r.area());
		}
	}
	
	public static void main(String[] args) {
		shape ref;
		circle c=new circle();
		polymethod(c);
		
		triangle t= new triangle();
		polymethod(t);
		
		rectangle r= new rectangle();
		polymethod(r);
		
		
		
		
		//		shape ref; // 부모
//			
//		// 부모객체에 대입가능
//		ref=new circle(); // 자식은 부모에게 맡길수 있다
//		System.out.println(ref.area());
//		
//		ref=new triangle();
//		System.out.println(ref.area());
//		
//		ref=new rectangle();
//		System.out.println(ref.area());
//		
////		circle c=new circle(); // 자식은 부모에게 맡길수 있다
////		System.out.println(c.area());
////		
////		triangle t=new triangle();
////		System.out.println(t.area());
////		
////		rectangle r=new rectangle();
////		System.out.println(r.area());
	}

}

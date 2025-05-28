package a250324;

class point3 {
	int x,y;
	
	public point3() { // 2개짜리 생성자를 만들었으면 디폴트 생성자도 만들어야함 
		//디폴트 생성자
	}

	public point3(int x, int y) { // 2개짜리 생성자
		this.x=x;
		this.y=y;
	}
	
	
	
//	@Override
	public String toString() {
		String str;
		str="("+x+","+y+")";
		return str;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bol=false;
		if(obj instanceof point3) {
			point3 p3=(point3) obj;
			if(x==p3.x && y==p3.y) bol=true;
			else bol=false;
		}
		
		return bol;
	}
	
	
}

public class test9 {

	public static void main(String[] args) {

		point3 p1= new point3 (10,20);
		point3 p2= new point3 (10,20);
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		//		point3 p= new point3();
//		System.out.println(p);
//		System.out.println(p.getClass());
//		System.out.println(p.hashCode());
//		System.out.println(p.toString());
//		
//		System.out.println("----------------------");
//		
//		
//		point3 p2= new point3();
//		System.out.println(p2);
//		System.out.println(p2.getClass());
//		System.out.println(p2.hashCode());
//		System.out.println(p2.toString());
//
//		
//		System.out.println(p==p2);
//		System.out.println(p.equals(p2));
	}

}

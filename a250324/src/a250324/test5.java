package a250324;


class outer1 {
	public int outdata=100;
	public Object outmethod() {
		
		class inner1 {
			
			public String toString() {
				return "점수:"+outdata;
			}
			
			public String jumsu() {
				return "성적:"+(outdata+1);
			}
		}
		
//		inner1 in=new inner1();
//		System.out.println(in.toString());
//		System.out.println(in.jumsu());
		
		return new inner1();
	}
}


public class test5 {
	public static void main(String[] args) {
		 outer1 out = new outer1();
		 Object xx= out.outmethod();
		 System.out.println(xx.toString());
		 System.out.println(xx.jumsu()); // 내부에서 만든것은 바깥에서 에러
		 //source => override/implement => equals, toString 문법 중요
	}
}

//class outer1 {
//	public int outdata=100;
//	public Object outmethod() {
//		class inner1  {
//			public String toString() {
//				return "점수:"+outdata;
//			}
//		}
//		return new inner1();
//	}
//}
//
//
//public class test5 {
//
//	public static void main(String[] args) {
//		outer1 out = new outer1();
//		Object obj = out.outmethod();
//		System.out.println();
//	}
//
//}

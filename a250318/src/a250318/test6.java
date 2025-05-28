package a250318;
//랩퍼 클래스 : 기본자료형을 객체화 하기 위해 클래스로 바꿈
// Integer, Double, Boolean, Character
//1. 정수(123)을 문자형 ("123")으로 바꾸기
//2. 문자열("123")을 정수로 바꾸어서 나누기 2 하기
public class test6 {

	public static void main(String[] args) {
		int a=123;
		double b = 10.5;
		Integer ia=Integer.valueOf(a); // 1)a를 클래스를 통하여 객체화 ia가 객체가 됨
		String sia=ia.toString(); // 2) 객체를 문자열로 바꾸기
		System.out.println(sia);
		
		//위 문구와 동일함
		String ssia=Integer.valueOf(a).toString();
		System.out.println(ssia);
		
		String xsia=String.valueOf(a);
		System.out.println(xsia);
		
		////
		System.out.println(Double.valueOf(b).toString());
		System.out.println(String.valueOf(b));
		
		/// 문자열을 정수로 변환하여 (/2)나누기 하시오

		Integer itemp=Integer.valueOf(ssia); // 문자열을 Integer형 객체
		int temp=itemp.intValue(); 	//기본자료형으로 변경
		System.out.println(temp/2);
		
	}

}

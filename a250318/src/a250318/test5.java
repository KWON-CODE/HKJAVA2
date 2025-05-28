package a250318;

// String 문자열
// int, double, boolean, char : 기본 자료형
// String 클래스자료형
//객체.equals() 같냐
//객체.length() 길이정보


public class test5 {

	public static void main(String[] args) {
		String name1= "홍길동";
		String name2 =new String("홍길동");
		
		if (name1== name2) System.out.println("같다");
		else System.out.println("다르다");
		
		if (name1.equals(name2)) System.out.println("같다2");
		else System.out.println("다름");
		
		System.out.println(name1.length());
		
		// String alpa=new String("abcdefgABCD");
		String alpa="abcdefgABCD"; // 스트링만 이런식으로 가능
			System.out.println(alpa.toLowerCase());
			System.out.println(alpa.charAt(2));
			
			for (int i=0;i<alpa.length();i++) {
				System.out.println(alpa.charAt(i));
			}
	}

}

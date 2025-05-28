package a250324;

//김씨 이씨 비교

class jumsu {
	int kor, eng, mat;
	public jumsu() {} // 디폴트 생성자
	
	public jumsu(int kor, int eng, int mat) {
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
		
		
	}

	@Override
	public String toString() {
		return "("+kor+","+mat+","+eng+")";
	}

	@Override
	public boolean equals(Object obj) {
		boolean bol=false;
		if(obj instanceof jumsu) {
			jumsu xx=(jumsu) obj;
			
			if(kor==xx.kor && eng==xx.eng && mat==xx.mat) bol=true;
			else bol=false;
		}
		
		return bol;
	}
	
	
}

public class test10 {
	public static void main(String[] arg) {
		jumsu kim=new jumsu(100,80,70);
		jumsu lee=new jumsu(100,80,70);
		String nameKim="gildong";
		String namelee="gildong";
		System.out.println(nameKim==namelee);
		System.out.println(nameKim.equals(namelee));
		
		System.out.println(kim.toString()); //(100, 80, 70)출력되게
		System.out.println(lee.toString()); // (100, 80, 70)출력되게
		System.out.println(kim.equals(lee)); // true 되게
		
		String name= new String("홍길동");
		String name2="홍길동";
		
		Integer num1= new Integer(10); // 비추천
		Integer num2= Integer.valueOf(10); //10이란 정수를 객체화 시킴
		Integer num3= 10; // boxing s박싱(정수를 객체화로 바로변환)
		
		
		int a= num3.intValue(); // num3 객체를 기본자료형(정수)로 변환
		int b= num3; // 언박싱(unboxing) 가능(객체를 기본 자료형으로 바로변환 )
	}
}

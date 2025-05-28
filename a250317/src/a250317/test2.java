package a250317;
// 클래스란 멤버변수와 멤버메소드로 구성된 구조
// 객체란 클래스를 통하여 생성된 결과물
// 아래는 붕어빵 클래스로 멤버변수는 틀, 팥 ,반죽 이있고 멤버 메소드= 함수 는 만들기()=메소드 가 있다.
class 붕어빵 {
	int 틀, 팥, 반죽;
	
	void 자료값받아오기 (int 반죽, int 팥) {
		this.반죽=반죽;
		this.팥=팥;
	}
	
	void 만들기() {
		틀= 반죽+팥;
	}
	
	void 출력() {
		System.out.println("한마리용량="+틀);
	}
}

public class test2 {

	public static void main(String[] args) {
		// 붕어빵(자료형) a= new(메모리 생성) 붕어빵();
		 	붕어빵 a= new 붕어빵();
		 	a.자료값받아오기(20, 10);
		 	a.만들기();
		 	a.출력();
	}

}

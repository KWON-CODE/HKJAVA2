package a250311;

// 1~100 까지 1씩 증가값 출력
// 1~100 까지 총합계 출력
// 1~100 까지 짝수만 출력
// 1~100까지 5의 배수의 총합계 출력
//for(초기값;조건;증감값) {}
public class test6 {

	public static void main(String[] args) {
		int a=0, hap=0;
		for (a=1;a<100;a=a+1 /*== a++, a+=1 */) {
			hap=hap+1;
			System.out.println(a);
		}
		System.out.println("합계="+hap);
		
		//짝수만 출력
		for(a=1;a<=100;a++) {
			if(a%2==0)
			System.out.println(a);
		}
		
		// 5의 배수의 합계
		hap=0;
		for(a=1;a<=100;a++) {
			if(a%5==0) {
				hap=hap+a;
			}
		}
		System.out.println("5의배수의 합계=" + hap);
		
		// 감소 조건
		for(a=100;a>=1;a--) {
			System.out.println(a);
		}
		
		//중요부분 for()함수의 초기치와 증감치를 별도로 대입가능
		a=1;
		for(;a<=100;) {
			System.out.println(a);
			a++;
		}
		
		//무"조건" 무한루프 
		for(;;) {
			System.out.println("무한루프");
		}
	}

}

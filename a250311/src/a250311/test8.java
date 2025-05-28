package a250311;
// while(조건식) {} --조건에 만족할때만 반복하는 문법 
// do {} while (조건식); -- 적어도 한번은 반드시 처리후 조건에 의해 반복
// 1-- 100까지 1씩 증가값 출력
public class test8 {

	public static void main(String[] args) {
		int a=0;
		do {
			a++;
			System.out.println(a);
		}while (a<100);

	}

}

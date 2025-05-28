package a250317class;

//로또번호 6개 랜덤 선택
//1-45 (45개중) 랜덤하게 6개 선택
//랜덤정수%갯수 + 초기값
//r%46+1

//import java.util.Random;
import java.util.*; // 유틸안의 모든정보 임포트


public class test6 {

	public static void main(String[] args) {
		Random r= new Random();
		int num;
		for(int i=1;i<=6;i++) {
			num=Math.abs(r.nextInt()%46)+1;
			System.out.println(num);
		}
		//int num=Math.abs(r.nextInt()%46)+1;
		
		//주사위 놀이 (1-6번호)번호 1개 추출하기
		num=Math.abs(r.nextInt()%6)+1;
		System.out.println("주사위번호="+num);
	}

}

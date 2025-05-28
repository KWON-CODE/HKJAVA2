package a250311;

// a,b,c 3개의 점수중 한 과목이라도 40미만이면 "불합격"
// 평균이 60점 미만이면 "불합격"
// 그외에는 합격이 출력 되도록 한다.

public class test3 {

	public static void main(String[] args) {
		int a=100, b=90, c=30;
		double avg;
		avg=(a+b+c)/3.0;
		if (a<40 || b<40 || c<40 || avg<60) System.out.println("불합격");
		else System.out.println("합격");
		
	}

}

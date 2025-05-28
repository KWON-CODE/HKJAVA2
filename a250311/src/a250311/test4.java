package a250311;

// 학점출력
// switch문 활용

public class test4 {

	public static void main(String[] args) {
		int a=100, b=90, c=80;
		double avg=(a+b+c)/3.0;
		int iavg=(int) avg;
		
		switch (iavg/10) {
		case 10:
		case 9: System.out.println("A학점"); break;
		case 8: System.out.println("B학점");	break;
		case 7: System.out.println("C학점");break;
		default: System.out.println("F학점");break;
		}

	}

}

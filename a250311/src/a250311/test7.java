package a250311;

//while()
//1~100까지 홀수만 출력하고, 홀수의 합계도 출력

public class test7 {

	public static void main(String[] args) {
		int i=0, hap=0;
		while (i<100) {
			i++;
			if(i%2==1) {
				System.out.println(i);
				hap=hap+i;
			}
		}
	}

}

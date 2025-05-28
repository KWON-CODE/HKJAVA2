package a250311;
// continue 계속
// break 빠져나감
public class test10 {

	public static void main(String[] args) {
		int i=0;
		for (i=1;i<=10;i++) {
			System.out.println(i);
			if(i%3==0) break;
		}
		
		for (i=1;i<=10;i++) {
			if(i%3==0) continue;
			System.out.println(i);
		}
	}

}

package a250317;

//5. money의 금액을 동전으로 바꾸었을 때 각각 몇개의 동전이 필요한가?
// int coinunit[]={500, 100, 50, 10};
// int money=3790;

public class test1 {

	public static void sub(int money) {
		int coinUnit[]= {500, 100, 50, 10};
		int mok;
		for (int i=0;i<4;i++) {
			mok=money/coinUnit[i];
			money=money%coinUnit[i];
			System.out.println(coinUnit[i]+"원:"+mok);
		}
	}
	
	public static void main(String[] args) {
		int money=3790;
		sub (money);
	}

}

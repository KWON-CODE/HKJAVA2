package a250324;

//1--100까지 합계를 구하는 중 합계가 50이상이 되면 예외발생해서 멈춤

public class test8 {

	public static void main(String[] args) throws Exception {
		int i=0, sum=0;
		Exception err=new Exception("합계50이상 멈춤");
		try {
		for (i=1;i<=100;i++) {
			sum=sum+i;
			if(sum>=50) throw err;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}

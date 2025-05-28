package a250311;
//배열

public class test11 {

	public static void main(String[] args) {
		int i=0;
		int a[]=new int[5];
		a[0]=10;
		a[1]=20;
		a[2]=80;
		a[3]=90;
		a[4]=100;
		for (i=0;i<5;i++) {
			System.out.println(a[i]);
		}
		// b배열의  값 중 가장 큰 값(최대값)을 출력
		int b[]= {90,80,70,100,55};
		int max=-999;
		int min=999;
		int sum=0;
		int count=0;
		for (i=0;i<b.length;i++) {
			if(b[i]>max) max=b[i];
			if(b[i]<min) min=b[i];
			sum=sum+b[i];
			if(b[i]%2==0) count=count+1; // 값이 짝수 것들의 개수
		}
		System.out.println("최대값="+max);
		System.out.println("최소값="+max);
		System.out.println("합계="+sum);
		System.out.println("짝수의갯수="+count);
	}
	
}

package a250311;

// 오름차순 정렬 a[]={90, 80, 70, 60, 50, 10}
public class test16 {
	
	
	public static void sort(int a[]) {
		int temp;
		for (int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	}
	public static void prn(int a[]) {
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int a[]= {90,80,70,60,50,10}

	}

}

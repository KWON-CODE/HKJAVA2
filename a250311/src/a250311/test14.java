package a250311;

// a배열에 저장된 값중 최대 값을 구하는 max() 매서드를 만드시오
public class test14 {

	static int max(int a[]) {
		int i;
		int imax=-999;
		for(i=0;i<a.length;i++) {
			if(a[i]>imax) imax=a[i];
		}
		return imax;
	}
	
	static int min(int a[]) {
		int i;
		int imin=9999;
		for(i=0;i<a.length;i++) {
			if(a[i]<imin) imin=a[i];
		}
		return imin;
	}
	
	static int evencnt(int a[]) {
		int count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]%2==0) count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int a [] = {10,90,80,78,66,55};
		int resmax=max(a);
		int resmin=min(a);
		int count=evencnt(a);
		System.out.println(resmax);
		System.out.println(resmin);
		System.out.println("짝수의갯수="+count);
		
	}

}

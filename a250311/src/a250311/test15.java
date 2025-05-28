package a250311;

//주민번호 체크 프로그램
public class test15 {

	public static void jumincheck(int a[]) {
		int b[] = {2,3,4,5,6,7,8,9,2,3,4,5};
		int check=0;
		for (int i=0;i<b.length;i++) {
			check=check+(a[i]*b[i]);
		}
		check= 11-(check%11);
		check=check%10;
		System.out.println(check);
		if(a[12]==check) System.out.println("올바른 주민번호");
		else System.out.println("잘못된 주민번호");
	}
	
	public static void main(String[] args) {
		int a[] = {8,0,1,1,0,4,1,0,0,1,3,2,2};
		jumincheck(a);
	}
	
}

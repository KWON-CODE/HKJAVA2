package a250311;
//2차원 배열

public class test12 {

	public static void main(String[] args) {
		int a[][]=new int[2][3];
		int i,j;
		a[0][0]=10;
		a[0][1]=20;
		a[0][2]=30;
		a[1][0]=40;
		a[1][1]=50;
		a[1][2]=60;
		for(i=0;i<a.length;i++) {
			for(j=0;j<a[i].length;j++) {
				System.out.println(a[i][j]);
			}
		}
		int b[][] = {{10,20,30},{40,50,60}};
		for(i=0;i<b.length;i++) {
			for(j=0;j<b[i].length;j++) {
				System.out.println(b[i][j]); 
			}
		}
	}
	

}

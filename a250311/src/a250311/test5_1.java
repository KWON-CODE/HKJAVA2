package a250311;

public class test5_1 {

	public static void main(String[] args) {
		int a,b,c=0;
		char ch;
		a=Integer.valueOf(args[0]);
		b=Integer.valueOf(args[2]);
		
		for(int i=0;i<4;i++) {
			ch=args[1].charAt(i);
			switch(ch) {
			case '+': c=a+b;break;
			case '-': c=a-b;break;
			case '*': c=a*b;break;
			case '/': c=a/b;break;
			}
			System.out.println(a+" "+ch+" "+b+" = "+c);
		}
	}

}

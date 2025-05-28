package a250311;

// 10 +-*/ 3
//덧셈 뺄셈 곱셈 나눗셈 모두 구하시오.

public class test5 {

	public static void main(String[] args) {
		int a,b,c=0;

		char ch1,ch2, ch3, ch4;

		a=Integer.valueOf(args[0]);

		ch1=args[1].charAt(0);

		ch2=args[1].charAt(1);

		ch3=args[1].charAt(2);

		ch4=args[1].charAt(3);

		b=Integer.valueOf(args[2]);

		switch(ch1) {

		case '+': c=a+b;break;

		case '-': c=a-b;break;

		case '*': c=a*b;break;

		case '/': c=a/b;break;

		}

		System.out.println(a+" " +ch1+" "+b+" = "+c);

		switch(ch2) {

		case '+': c=a+b;break;

		case '-': c=a-b;break;

		case '*': c=a*b;break;

		case '/': c=a/b;break;

		}

		System.out.println(a+" " +ch2+" "+b+" = "+c);

		switch(ch3) {

		case '+': c=a+b;break;

		case '-': c=a-b;break;

		case '*': c=a*b;break;

		case '/': c=a/b;break;

		}

		System.out.println(a+" " +ch3+" "+b+" = "+c);

		switch(ch4) {

		case '+': c=a+b;break;

		case '-': c=a-b;break;

		case '*': c=a*b;break;

		case '/': c=a/b;break;

		}

		System.out.println(a+" " +ch4+" "+b+" = "+c);
	}

}

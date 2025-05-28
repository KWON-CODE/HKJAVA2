package a250331;

import java.awt.EventQueue;

public class test {

	public static void main(String[] args) {
		ThreadTest mythread1=new ThreadTest("홍길동");
		ThreadTest mythread2=new ThreadTest("이순자");
		
		mythread1.start();
		mythread2.start();

	}

}

 
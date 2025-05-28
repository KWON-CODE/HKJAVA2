package a250331;

import java.awt.EventQueue;


public class test2 {

	public static void main(String[] args) {
		ThreadTest2 my1=new ThreadTest2("홍길동");
		ThreadTest2 my2=new ThreadTest2("이순자");
		
		Thread t1= new Thread(my1);
		Thread t2= new Thread(my2);

		t1.start();
		t2.start();
		EventQueue.invokeLater(my1);
	}

}

package a250331;


class MainData {
	int data = 100;
	//입금시 lock 처리 (다른사람 접근안됨) == synchronized
	public synchronized void up(String name) {
		data++;
		System.out.println(name + "님이"+ data+"로 증가시킴");
	}
	public synchronized void down(String name) 
	{
		data--;
		System.out.println(name + "님이"+ data+"로 감소시킴");

	}
}

public class threadSample {

	
	public static void main(String[] args) {
		MainData m = new MainData();
		IncThread t1 = new IncThread(m, 500, "홍길동 입금");
		DecThread t2 = new DecThread(m, 70,"이순자 감소");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		

	}

}

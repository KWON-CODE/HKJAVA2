package a250331;

public class ThreadTest2 implements Runnable {
	
	
	int num= 0;
	String name;
	
	public ThreadTest2 (String name) {
		this.name=name;
	};
	
	public ThreadTest2 () {}
	
	
	public void run() {
		while(true) {
			System.out.println(num);
			num++;
			try {
			Thread.sleep(1000);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}

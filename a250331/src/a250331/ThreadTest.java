package a250331;

public class ThreadTest extends Thread {
	int num=0;
	String name;
	
	public ThreadTest(String name) {
		this.name=name;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(name +" : "+ num );
			num++;
			try {
				sleep(1000);

			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}

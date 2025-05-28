package a250331;

public class IncThread extends Thread {
	MainData m;
	int to;
	String name;	
	public IncThread() {
		
	}
	public IncThread(MainData m, int to, String name) {
		this.m=m;
		this.to=to;
		this.name=name;
	}
	public void run() {
		for(int i=0;i<to;i++) {
			m.up(name);
			try {
				sleep(5000);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
}

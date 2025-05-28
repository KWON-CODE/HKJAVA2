package a250331;

//출금통장
public class DecThread extends Thread {
	
	MainData m;
	int to;
	String name;
	
		public DecThread(MainData m , int to, String name) {
			this.m=m;
			this.to=to;
			this.name=name;
		}
		public void run() {
			for(int i=0;i<to;i++) {
				m.down(name);
				try {
					sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
}

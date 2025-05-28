package a250331;

// 스레드 : 입금/출금/조회

public class test3 {

	public static void main(String[] args) {
		Thread t1= new Thread(new Runnable () {
			int num=0;
			public void run() {
				while(true) {
					System.out.println(num);
					num++;
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
			}
		});
		t1.start();
	}

}

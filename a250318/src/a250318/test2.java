package a250318;

public class test2 {

	public static void main(String[] args) {
		sungjuk man= new sungjuk();
		man.set(100, 100,80);
		man.cal();
		man.show();
		
		man.setKor(90);
		man.cal();
		man.show();
		
		sungjuk hong=new sungjuk(90,80,30);
		hong.cal();
		hong.show();
		
	}

}

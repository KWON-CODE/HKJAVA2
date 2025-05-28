package a250317class;

public class test2 {

	public static void main(String[] args) {
		Account.total=100; // 원래 안되는게 되는것;
		
		Account a= new Account();
				// a.total=10; // 일반적인 사용법
				a.cal();
				a.show();
				
		Account b= new Account();
				b.cal();
				b.show();
		
		Account c= new Account();
				c.cal();
				// c.show();
				Account.show();
	}

}

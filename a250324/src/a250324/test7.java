package a250324;



public class test7 {

	public static void main(String[] args) {
		String name=null;
		int a=3, b=0;
		
		try {
			System.out.println(name.toString());
			System.out.println(a/b);
		} catch (ArithmeticException e) {
			// e.printStackTrace();
			System.out.println("산술에러");
		} catch (NullPointerException e) {
			System.out.println("널에러");
		} finally {
			System.out.println("끝");
		}
	}

}

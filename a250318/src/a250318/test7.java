package a250318;

public class test7 {
	
	static int total = 0;
	static double avg = 0.0; 
	public static void cal(String[] jumsu) {
		for (int i = 0; i < jumsu.length; i++) {
			total += Integer.parseInt(jumsu[i]);
		}
		avg = (double) total / jumsu.length;
	}

	public static void prn() {
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
	}

	public static void main(String[] args) {
		String jumsu[] = {"90", "100", "80", "70"};
		cal(jumsu);
		prn();
	}

}
package a250317;

class sungjuk {
	// int kor= 100,eng=200,mat,sum; << 이런식으로 값을 미리 지정하는 경우는 거의 없다.
	int kor,eng,mat,sum;
	double avg;
	
	
	
	
	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	void set (int kor, int eng, int mat) {
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
		// 이름이 다르면 this를 붙힐 필요가 없다
		// this를 붙히는게 원칙이나 생략가능
	}
	
	void total() {
		sum=kor+eng+mat;
		avg=sum/3.0;
	}
	void prn() {
		System.out.println(sum);
		System.out.println(avg);
	}
}

public class test3 {

	public static void main(String[] args) {
		sungjuk a = new sungjuk();
		a.set(100, 90, 80);
		a.total();
		a.prn();
		
		sungjuk man= new sungjuk();
		man.setKor(10);
		man.setEng(100);
		man.setMat(90);
		man.total();
		man.prn();
	}

}

package a250318;

//한과목이라도 40미만이거나 평균이 60미만이면 불합격 출력 그외 합격 출력

public class sungjuk {
	public int kor, eng, mat;
	public int tot,avg;
	public String res;
	
	public void cal() {
		tot=kor+eng+mat;
		avg=tot/3;
		if (kor<40 || eng<40 || mat<40 || avg<60) res="불합격";
		else res="합격";
	}
	
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public sungjuk(int kor, int eng, int mat) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public sungjuk() { // 생성자 메소드() 클래스와 이름이 같음
		super();
	}
	
	public void set (int kor, int mat, int eng) {
		this.kor=kor;
		this.mat=mat;
		this.eng=eng;
	}
	
	public void show() {
		System.out.println("평균="+avg);
		System.out.println("결과="+res);
	}
}

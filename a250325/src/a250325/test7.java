package a250325;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

//Iterator 인터페이스 : 순차적으로 하나씩 접근하기 할때 사용
//Enumeration 인터페이스 : 순차적으로 하나씩 접근하기 할때 사용
// Set 인터페이스 : 집합
// HashTable 클래스 : ArrayList<key자료형, Value자료형> 자료형이 2개인 구조
//put(), get() 활용


public class test7 {

	public static void prn(Hashtable<String, Double> kim) {
		Set<String> set=kim.keySet();
		for(String key : set) {
			System.out.println(key+"========"+kim.get(key));
	}
	}	
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in); // 입력장치
		String name=sc.nextLine(); // 콘솔창에 입력하면 그값이 나오게
		
		//String name=args[0];
	    //	System.out.println(name);
		// 콘솔로 입력받아서 해당되는 사람의 이름과 신장출력
		
		Hashtable<String, Double> kim = new Hashtable<String, Double>();
		kim.put("김길동", 182.5);
		kim.put("김순자", 180.1);
		kim.put("김기자", 167.1);
		kim.put("김귀", 172.3);
		//Set<String> set=kim.keySet();
		System.out.println(name + "======="+ kim.get(name)); 
		// prn (kim);
		}
	}


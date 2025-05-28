package a250317class;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import java.util.*;

import java.util.Date;

public class test5 {

	public static void main(String[] args) {
		Date today=new Date();
		SimpleDateFormat form= 
				new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		//System.out.println(today);
		System.out.println(form.format(today));
		
		Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)+1; // +1하는 이유 월은 처음에 0월부터 나감 Calendar의 특징
		int day=now.get(Calendar.DATE);
		System.out.println(year+"년"+month+"월"+day+"일");
		
		int h=now.get(Calendar.HOUR);
		int m=now.get(Calendar.MINUTE);
		int s=now.get(Calendar.SECOND);
		System.out.println(h+"시"+m+"분"+s+"초");
	}

}

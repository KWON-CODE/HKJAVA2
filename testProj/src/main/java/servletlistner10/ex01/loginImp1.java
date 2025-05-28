package servletlistner10.ex01;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class loginImp1 implements HttpSessionBindingListener {
	String user_id;
	String user_pw;
	static int total_user=0;
	
	
	public loginImp1() {
		
	}

	public loginImp1(String user_id, String user_pw) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		// ++total_user;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속함");
		++total_user;
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속 끝");
		total_user--;
	}
}

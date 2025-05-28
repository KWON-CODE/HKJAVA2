package a250414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class ipTest {

	public static void main(String[] args) {
		BufferedReader br;
		InetAddress myadd, add[], myip;
		String url=null;
		
		br= new BufferedReader(new InputStreamReader(System.in));
		try {
			url = br.readLine();			
			myadd = InetAddress.getByName(url); // 인터넷 ip
			System.out.println(myadd.getHostAddress());
			
			add=InetAddress.getAllByName(url);
			
			for(int i = 0; i<add.length;i++) {
				System.out.println(add[i]);
			}
			
			myip = InetAddress.getLocalHost();
			System.out.println("내자리의 ip는" +myip);
			System.out.println("내자리의 ip는" +myip.getHostAddress());
		} catch (Exception e) {

		}
	}

}

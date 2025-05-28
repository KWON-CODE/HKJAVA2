package a250331;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.TextArea;

public class appletTest2 extends Applet {
	
	TextArea myarea;
	
	
	@Override
	public void init() {
		this.setLayout(null);
		
		myarea=new TextArea(20,20);
		myarea.setBounds(10,30,380,200);
		this.add(myarea);
		myarea.append("초기화\n");
		super.init();
	}

	@Override
	public void start() {
		myarea.append("시작\n");
	}

	@Override
	public void stop() {
		myarea.append("종료\n");
	}

	@Override
	public void destroy() {
		myarea.append("소멸\n");
	}

	@Override
	public void paint(Graphics g) {
		myarea.append("그리기\n");
		
	}

}

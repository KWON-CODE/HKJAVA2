package a250331;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;

public class test4 extends Applet implements Runnable {

	
	Thread clock;
	Font myfont;
	
	@Override
	public void init() {
		myfont=new Font("Serif", Font.BOLD, 40);
		this.setBackground(Color.yellow);
		this.setFont(myfont);
	}



	@Override
	public void start() {
		if(clock==null) {
			clock = new Thread(this);
			clock.start();
		}
	}



	@Override
	public void stop() {
	 if ((clock != null) && (clock.isAlive())) {
		 clock=null;
	 }
	}



	@Override
	public void destroy() {

	}

	
	@Override
	public void paint(Graphics g) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int date = now.get(Calendar.DATE);
		int hour = now.get(Calendar.HOUR);
		int min = now.get(Calendar.MINUTE);
		int sec = now.get(Calendar.SECOND);
		g.drawString(year + "-" + month +"-" + date + " " + hour + " :" +min + ":" +sec, 10, 40);

	}
	

	

	@Override
	public void run() {
		while(true) {
			try {
				clock.sleep(1000);

			} catch (Exception e) {
				e.printStackTrace();
			}
			repaint();

		}
	}

}

package a250331;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class appletTest3 extends Applet {

	@Override
	public void paint(Graphics g) {
	 g.drawString("해피바이러스", 50, 50);
	 Font f1=new Font("궁서체", Font.BOLD, 15);
	 g.setFont(f1);
	 g.drawString("해피바이러스", 50, 90);
	 Color c1= new Color(255,0,0);
	 g.setColor(c1);
	 g.drawString("해피바이러스", 50, 140);
	 g.setColor(Color.blue);
	 g.drawString("해피바이러스", 50, 200);
	}
	

}

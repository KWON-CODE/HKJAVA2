package a250331;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class appletTest4 extends Applet {

	@Override
	public void paint(Graphics g) {
		g.drawLine(50, 100, 150, 100);
		g.drawRect(250, 100, 100, 100);
		g.setColor(new Color(0,0,255));
		g.fillOval(450, 100, 100, 100);
		
		int x[] = {650,600,700};
		int y[] = {100,200,200};
		g.drawPolygon(x, y, x.length);
	}
	
}

package a250331;

import java.applet.Applet;
import java.awt.Graphics;

public class appletTest extends Applet {

	@Override
	public void paint(Graphics g) {
		g.drawString("연습애플릿", 50, 100);
		super.paint(g);
	}

}

package awtSample2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingTest extends JFrame {
	
	JLabel lbl; // j자 앞에 붙으면 스윙라이브러리 이둉하는 Label 컴포넌트임
	JTextField tf;
	JButton btn;
	public SwingTest() {
		this.setVisible(true);
		this.setTitle("스윙연습");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}
	
	public void init() {
		this.setLayout(null);
		lbl = new JLabel("이름");
	}
}

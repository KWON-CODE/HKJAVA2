package awtSample;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test2 extends Applet implements ActionListener {
	
	Label lbl1, lbl2;
	TextField id,name;
	Button btn1, btn2;
	TextArea ta;
	public void init() {
		this.setLayout(null); // 배치관리자를 null(절대위치)로 변경
		lbl1 = new Label("아이디");
		lbl2 = new Label("이름");
		lbl1.setBounds(20, 20,50,20);
		lbl2.setBounds(20, 50, 50 , 20);
		
		this.add(lbl1);
		this.add(lbl2);
		
		
		id= new TextField(20);
		name = new TextField(20);
		
		id.setBounds(100, 20, 100, 20);
		name.setBounds(100, 50, 100, 20);

		this.add(id);
		this.add(name);
		
		btn1= new Button("실행");
		btn2 = new Button("취소");
	
		btn1.setBounds(100,320,50,20);
		btn2.setBounds(160,320,50,20);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		this.add(btn1);
		this.add(btn2);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			System.out.println("btn1클릭.");

		} else if(e.getSource() == btn2)
		System.out.println("btn2.");
	}
}


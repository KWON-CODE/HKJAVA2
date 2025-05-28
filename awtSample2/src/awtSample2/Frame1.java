package awtSample2;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.List;


public class Frame1 extends Frame 
 					implements WindowListener, ActionListener{
	
	Label lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
	TextField name, juso, phone;
	Button btnOk, btncan;
	Choice ch;
	List list;
	Checkbox cb1, cb2, cb3;
	CheckboxGroup cg;
	Scrollbar sc;
	TextArea ta, reta;
	
	public Frame1() {
		this.setSize(800, 1000);
		this.setVisible(true);
		this.setTitle("frameTest");
		this.addWindowListener(this);
		init();
	}
	
	public void init() {
		this.setLayout(null);  //배치관리자 없음으로 지정해야 컴포넌트를 한개씩 배치할수 있다 setBounds()
		lbl1=new Label("이름");   //레이블 컴포넌트 생성
		lbl2=new Label("주소");
		lbl3=new Label("전화번호");
		lbl4=new Label("성별");
		lbl5=new Label("직업");
		lbl6=new Label("취미");
		lbl7=new Label("자기소개");
		lbl1.setBounds(20, 30, 50, 20);
		lbl2.setBounds(20, 60, 50, 20);
		lbl3.setBounds(20, 90, 50, 20);
		lbl4.setBounds(20, 120, 50, 20);
		lbl5.setBounds(20, 150, 50, 20);
		lbl6.setBounds(20, 180, 50, 20);
		lbl7.setBounds(20, 210, 50, 20);
		this.add(lbl1);this.add(lbl2);this.add(lbl3);
		this.add(lbl4);this.add(lbl5);this.add(lbl6);
		this.add(lbl7);

		name=new TextField(20);
		juso=new TextField(20);
		phone=new TextField(20);
		name.setBounds(100, 30, 100, 20);
		juso.setBounds(100, 60, 100, 20);
		phone.setBounds(100, 90, 100, 20);
		this.add(name);this.add(juso);this.add(phone);

		cg=new CheckboxGroup();
		cb1=new Checkbox("남자",cg, true);
		cb2=new Checkbox("여자",cg, false);
		cb1.setBounds(100, 120, 50, 20);
		cb2.setBounds(160, 120, 50, 20);
		this.add(cb1);this.add(cb2);

		ch=new Choice();
		ch.addItem("개발자");
		ch.addItem("DB관리자");
		ch.addItem("서버관리자");
		ch.addItem("IT교육");
		ch.setBounds(100, 150, 100, 20);
		this.add(ch);

		list=new List(1, true);
		list.add("독서");
		list.add("영화관람");
		list.add("운동");
		list.add("유튭보기");
		list.add("등산");
		list.setBounds(100, 180, 100, 20);
		this.add(list);

		ta=new TextArea(300, 100);
		ta.setBounds(100, 210, 300, 100);
		this.add(ta);

		btnOk=new Button("실행");
		btncan=new Button("취소");
		btnOk.setBounds(100, 320, 50, 20);
		btncan.setBounds(160, 320, 50, 20);
		
		btnOk.addActionListener(this);   //btnOk컴포넌트에 액션을 추가함
		btncan.addActionListener(this);  //btncan컴포넌트에 액션을 추가함
		
		this.add(btnOk);
		this.add(btncan);
		
		
		

		reta=new TextArea(500, 300); // 결과내역이 출력되는
		reta.setBounds(100, 350, 500, 300);
		this.add(reta);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnOk) {
			//System.out.println("ok버튼");
			reta.append("이름=" + name.getText()+"\n");
			reta.append("주소=" + juso.getText()+"\n");
			reta.append("전화번호=" + phone.getText()+"\n");
			Checkbox tempcb=(cb1.getState()==true)? cb1 : cb2; 
			System.out.println(cb1.getState()); // 콘솔창
			
			reta.append("성별=" + tempcb.getLabel()+"\n");
			reta.append("직업=" + ch.getSelectedItem()+"\n");
			reta.append("취미=" + list.getSelectedItem()+"\n");
			reta.append("자기소개=" + ta.getText() + "\n");
			
		}
		else 
		if(e.getSource()==btncan) {
			//System.out.println("can버튼");
			name.setText("");
			juso.setText("");
			phone.setText("");
			ta.setText("");
			cb1.setState(true);
			reta.setText("");
	

		}
	}


}
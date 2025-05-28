package awtSample;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Label;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.TextArea;
// 컨트롤 + 쉬프트 + o 키
import java.awt.TextField;


public class test1 extends Applet {

	Label lbl1,lbl2,lbl3;
	TextField tf1, tf2, tf3;
	Button btn1,btn2,btn3;
	Checkbox ch1,ch2,ch3,ch4;
	CheckboxGroup cg;
	Choice cho1, cho2;
	List li;
	TextArea ta;
	Scrollbar sb1, sb2;
	
	
	public void init() {
		
		
		lbl1=new Label("name");
		lbl2=new Label("id");
		lbl3=new Label("pwd");
		
		tf1=new TextField(10);
		tf2=new TextField(10);
		tf3=new TextField(10);
		
		btn1= new Button("btn1");
		btn2= new Button("btn2");
		btn3= new Button("btn3");
		
//		cho1 = new choice();
//		cho1= addItem("java");
		
		li=new List();
		li.add("java");
		li.add("c");
		li.add("c++");
		
		cho1 = new Choice();
		cho1.add("자바");
		cho1.add("C++");
		cho1.add("자바스크립트");


		
		ta= new TextArea(5,20);
		// Scrollbar (종류, 현재위치 , 버블크기, 초기값, 최종값);
		sb1= new Scrollbar(Scrollbar.HORIZONTAL, 50,0,1,100);
		sb2= new Scrollbar(Scrollbar.VERTICAL, 50,0,1,100);
		
		
//		lbl1.setBackground(Color.red);
//		lbl2.setAlignment(Label.RIGHT);
		
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		ch1=new Checkbox("reading");
		ch2=new Checkbox("gameing");
		cg= new CheckboxGroup();
		ch3= new Checkbox("man", true, cg);
		ch4= new Checkbox("woman", false, cg);

		this.add(tf1);
		this.add(tf2);
		this.add(tf3);
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		
		this.add(ch1);
		this.add(ch2);
		this.add(ch3);
		this.add(ch4);
		
		this.add(cho1);
		this.add(li);
		this.add(ta);
		this.add(sb1);
		this.add(sb2);
	}
}

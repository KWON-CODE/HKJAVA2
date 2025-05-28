import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class fCustomer implements ActionListener {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	JButton btnMoveFirst, btnMovePrev, btnMoveNext, btnMoveLast, btnInsertItem,btnDeleteItem, btnSaveItem, btnPrintItem, btnCloseWindow;

	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="oracle";
	String sqlselect = "select c_no, c_name, c_addr, c_phone, c_dist from customer";

	String customer_dist[] = {"개인고객", "기업고객"}; // 00: 기업고객, 01: 기업고객

	JComboBox jcb1=null;
	String strCno,strCname,strCaddr,strCphone, strDist;
	int intIndex;

	
	Connection conn=null; // DB연결
	Statement stmt=null; // 문장통
	ResultSet rs= null; // 결과통

	/**
	 * Launch the application.
	 */
	////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fCustomer window = new fCustomer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//////////////////////////////////////////////////////////////////
	/**
	 * Create the application.
	 */
	public fCustomer() {
		initialize();
		initdb();
		tfClear();
	}

	////////////////////////////////////
	///텍스트필드 내용지우기
	
	public void tfClear() {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	// 오라클 드라이브 연걸 버전 : ojdbc 11
	public void initdb() {
		try {
			Class.forName(driver); // 메모리로 드라이버를 로딩
			conn=DriverManager.getConnection(url,user,password); // 오라클서버로 연결
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // 문장통만들기
			rs=stmt.executeQuery(sqlselect); // 문장(sqlselect)을 넣어서 실행한(execute) 결과는 rs에 보관
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/////////////////////////////////////////////////////////////////////////////
	/**
	 * 화면디자인 : 고객관리화면
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("고객관리");
		frame.setBounds(100, 100, 628, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("고객번호");
		lblNewLabel.setBounds(12, 96, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("고객이름");
		lblNewLabel_1.setBounds(12, 141, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("주소");
		lblNewLabel_2.setBounds(12, 195, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setBounds(12, 250, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		tf1 = new JTextField();
		tf1.setBounds(103, 93, 116, 21);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(103, 138, 116, 21);
		frame.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBounds(103, 192, 116, 21);
		frame.getContentPane().add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setBounds(103, 247, 116, 21);
		frame.getContentPane().add(tf4);
		tf4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("고객구분");
		lblNewLabel_4.setBounds(12, 314, 57, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		 jcb1 = new JComboBox();
		//jcb1.setModel(new DefaultComboBoxModel(new String[] {"개인고객", "기업고객"}));
		for(int i=0;i<customer_dist.length;i++) {
			jcb1.addItem(customer_dist[i]);
		}
				
		jcb1.setBounds(97, 310, 122, 23);
		frame.getContentPane().add(jcb1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(12, 10, 525, 17);
		frame.getContentPane().add(toolBar);
		
		
		btnMoveFirst = new JButton("");
		btnMoveFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMoveFirst.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\FIRST.GIF"));
		toolBar.add(btnMoveFirst);
		
		 btnMovePrev = new JButton("");
		btnMovePrev.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\PREV.GIF"));
		toolBar.add(btnMovePrev);
		
		 btnMoveNext = new JButton("");
		btnMoveNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMoveNext.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\NEXT.GIF"));
		toolBar.add(btnMoveNext);
		
		 btnMoveLast = new JButton("");
		btnMoveLast.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\LAST.GIF"));
		toolBar.add(btnMoveLast);
		
		 btnInsertItem = new JButton("");
		btnInsertItem.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\INSERT.GIF"));
		toolBar.add(btnInsertItem);
		
		 btnDeleteItem = new JButton("");
		btnDeleteItem.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\DELETE.GIF"));
		toolBar.add(btnDeleteItem);
		
		 btnSaveItem = new JButton("");
		btnSaveItem.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\SAVE.GIF"));
		toolBar.add(btnSaveItem);
		
		 btnPrintItem = new JButton("");
		btnPrintItem.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\PRINT.GIF"));
		toolBar.add(btnPrintItem);
		
		 btnCloseWindow = new JButton("");
		btnCloseWindow.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\EXIT.GIF"));
		toolBar.add(btnCloseWindow);
		
		btnMoveFirst.addActionListener(this);
		btnMovePrev.addActionListener(this);
		btnMoveNext.addActionListener(this);
		btnMoveLast.addActionListener(this);
		btnInsertItem.addActionListener(this);
		btnDeleteItem.addActionListener(this);
		btnSaveItem.addActionListener(this);
		btnPrintItem.addActionListener(this);
		btnCloseWindow.addActionListener(this);
		
		
	}
////////////////////////////////////////////////////////
	//버튼들 액션이벤트 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnMoveFirst) {
			MoveFirst();
			
		} else if(e.getSource()==btnMovePrev) {
			MovePrev();
			
		}else if(e.getSource()==btnMoveNext) {
			MoveNext();
			
		}else if(e.getSource()==btnMoveLast) {
			MoveLast();
			
		}else if(e.getSource()==btnInsertItem) {
			InsertItem();
			
		}else if(e.getSource()==btnDeleteItem) {
			DeleteItem();
			
		}else if(e.getSource()==btnSaveItem) {
			SaveItem();
			
		}else if(e.getSource()==btnPrintItem) {
			PrintItem();
			
		}else if(e.getSource()==btnCloseWindow) {
			CloseWindow();
			
		}
	}
	///창닫기
private void CloseWindow() {
		// TODO Auto-generated method stub
		
	}
///DB 프린트출력
private void PrintItem() {
		// TODO Auto-generated method stub
		
	}

//DB 저장
private void SaveItem() {
	if (getItems()) {
		try {
			rs.updateString(1, strCno);
			rs.updateString(3, strCname);
			rs.updateString(3, strCaddr);
			rs.updateString(4, strCphone);
			rs.updateString(5, strDist);
			rs.updateRow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	}
//////DB삭제
private void DeleteItem() {
	int rvalue= JOptionPane.showConfirmDialog(null, "현재 데이터를 삭제합니다.", "확인", 
			JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		System.out.println(rvalue);
	try {
		if(rvalue==0) {
			rs.deleteRow();
			MoveNext();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}


public boolean getItems() {
	strCno = tf1.getText().trim(); // trim() 앞뒤 공백제거
	strCname = tf2.getText().trim();
	strCaddr = tf3.getText().trim();
	strCphone = tf4.getText().trim();
	intIndex = jcb1.getSelectedIndex(); // 배열구조이므로 0첨자,1첨자
	if(intIndex==1) strDist="00";
	else if (intIndex==1) strDist="11";
	if(strCno.length()<=0) {
		JOptionPane.showMessageDialog(null, "고객번호가 누락되었습니다");
		return false;
	}
	if(strCname.length()<=0) {
		JOptionPane.showMessageDialog(null, "이름이 누락되었습니다");
		return false;
	}
	return true;
}


////DB삽입
private void InsertItem() {
	if(getItems()) {
	try {	
		rs.moveToInsertRow(); // rs통에 한행을 추가
		rs.updateString(1, strCno); // trim()은 가져온 데이터의 앞뒤의 공백제거
		rs.updateString(2, strCname);
		rs.updateString(3, strCaddr);
		rs.updateString(4, strCphone);
		rs.updateString(5, strDist);
		rs.insertRow(); // db에 insert되어 변경됨
		rs.moveToCurrentRow();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	}

// 마지막페이지 이동
private void MoveLast() {
	try {
		if(!rs.isLast()) { // 마지막레코드가 아닐때
			rs.last(); // rs의 마지막레코드로 이동
			setItems(); // rs의 각각 필드들을 텍스트필드로 가져오는 동작
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

//DB 다음필드로 이동
private void MoveNext() {
	try {
		if(!rs.isLast()) { // 마지막 레코드가 아닐때
			rs.next(); // rs의 다음레코드로 이동
			setItems(); // rs의 각각필드들을 텍스트 필드로 가져오는 동작
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
//DB 이전필드로 이동
private void MovePrev() {
	try {
		if(!rs.isFirst()) { // 첫레코드 아니면
			rs.previous(); // 이전레코드로 이동
			setItems(); // rs의 각자 필드들을 텍스트필드로 가져오는 동작
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

public void setItems() {
	try {
		tf1.setText(rs.getString(1));
		tf2.setText(rs.getString(2));
		tf3.setText(rs.getString(3));
		tf4.setText(rs.getString(4));
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//////첫번째 화면으로 이동
private void MoveFirst() {
 try {
	if(!rs.isFirst()) {
		rs.first();
		setItems();
	}
	
} catch (Exception e) {
	e.printStackTrace();
}
		
}
}

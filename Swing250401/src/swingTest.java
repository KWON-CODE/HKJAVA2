import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JScrollPane;

//멤버변수 private 붙히는것 원칙 (public , protected)
// 멤버메서드는 public 붙히는것 원칙
public class swingTest implements ActionListener {

	private JFrame frame;
	private JTextField txtNo;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtTel;
	private JTable table;
	private JButton btnTotal, btnAdd, btnDel, btnSearch ,btnCancel;
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="system";
	private String password="oracle";
	private String sqlInsert="insert into customer(code, name, email, tel) values(?,?,?,?)"; 
	private String sqlSelect="select * from  customer";
	private String sqlSelect2="select * from  customer where name=?";
	private String sqlUpdate="update customer set email=? where code=?";
	private String sqlDelete="delete customer where code=? ";
	
	private  Connection conn=null;
	private  PreparedStatement pstmtInsert=null, pstmtUpdate=null, pstmtDelete=null;
	private PreparedStatement pstmtTotal=null, pstmtTotalScroll=null;
	private PreparedStatement pstmtSearch=null, pstmtSearchScroll=null;

	private ResultSet rs=null;
	
	// 로직상 필요한 변수들 
	private static final int NONE=0;
	private static final int ADD=1;
	private static final int DELETE=2;
	private static final int SEARCH = 3;
	private static final int TOTAL = 4;
	int cmd=NONE; // 전기스위치 = 꺼져있음
	// **************************************

	MyModel model = null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() { //스레드 start(EventQueue.invokeLater) => run()
			public void run() {
				try {
					swingTest window = new swingTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public swingTest() {
		initialize();//디자인에서 작성된 화면디자인	
		initText(); // 텍스트상자의 내용을 지우는 함수
		dbConnection(); // DB연동
	}

	public void initText() {
		txtNo.setText("");
		txtName.setText("");
		txtEmail.setText("");
		txtTel.setText("");
		txtNo.setEditable(false);
		txtName.setEditable(false);
		txtEmail.setEditable(false);
		txtTel.setEditable(false);
	}
	public void dbConnection() {
		try {
			Class.forName(driver); // 1.드라이버를 메모리로 로딩
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("db연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("고객 관리");
		frame.setBounds(100, 100, 654, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("번호");
		lblNewLabel_3.setBounds(12, 28, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("이름");
		lblNewLabel_4.setBounds(12, 77, 57, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이메일");
		lblNewLabel_5.setBounds(12, 130, 57, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("전화번호");
		lblNewLabel_6.setBounds(12, 174, 57, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		txtNo = new JTextField();
		txtNo.setBounds(66, 25, 116, 21);
		frame.getContentPane().add(txtNo);
		txtNo.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(66, 74, 116, 21);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(66, 127, 116, 21);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setBounds(66, 171, 116, 21);
		frame.getContentPane().add(txtTel);
		txtTel.setColumns(10);
		
		
		// btnTotal 등의 버튼들을 전역으로 선언하기
		
		btnTotal = new JButton("전체보기");
		btnTotal.setBounds(12, 212, 97, 23);
		frame.getContentPane().add(btnTotal);
		
		btnAdd = new JButton("추가");
		btnAdd.setBounds(121, 212, 97, 23);
		frame.getContentPane().add(btnAdd);
		
		btnDel = new JButton("삭제");
		btnDel.setBounds(228, 212, 97, 23);
		frame.getContentPane().add(btnDel);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(347, 212, 97, 23);
		frame.getContentPane().add(btnSearch);
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(473, 212, 97, 23);
		frame.getContentPane().add(btnCancel);
		
		btnTotal.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnSearch.addActionListener(this);
		btnCancel.addActionListener(this);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 28, 197, 161);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==btnAdd) {
			//System.out.println(btnAdd.getText());
			if(cmd!=ADD) {
				frame.setTitle("데이터추가");
				setTextField(ADD); // 텍스트필드들을 초기화하기위한 함수
				setButton(ADD); // 버튼들을 초기화하기 위한 함수
				return;
			}
			add();
			
		}else if(e.getSource()==btnDel) {
			if(cmd!=DELETE) {
				frame.setTitle("데이터삭제");
				setTextField(DELETE);
				setButton(DELETE);
				return;
			};
			del();
			//System.out.println(btnDel.getText());

		}else if(e.getSource()==btnSearch) {
			if(cmd!=SEARCH) {
				frame.setTitle("데이터검색");
				setTextField(SEARCH);
				setButton(SEARCH);
				return;
			};
			search();
			//System.out.println(btnSearch.getText());
		} else if(e.getSource()==btnTotal) {
			//	System.out.println(btnTotal.getText());
			
			setTextField(TOTAL);
			setButton(TOTAL);
			total();
			}
		 setTextField(NONE);
		 setButton(NONE);
	}
	
	public void setTextField(int cmd) { // ADD, SEARCH ,DELETE
		switch (cmd) {
		case ADD:
			txtNo.setEditable(true);
			txtName.setEditable(true);
			txtEmail.setEditable(true);
			txtTel.setEditable(true);
			break;
			
		case DELETE:
			txtNo.setEditable(true);
			txtName.setEditable(false);
			txtEmail.setEditable(false);
			txtTel.setEditable(false);
			break;
		
		case SEARCH:
			txtNo.setEditable(false);
			txtName.setEditable(true);
			txtEmail.setEditable(false);
			txtTel.setEditable(false);
			break;
		
		case NONE:
			txtNo.setEditable(false);
			txtName.setEditable(false);
			txtEmail.setEditable(false);
			txtTel.setEditable(false);
			break;
		}
		setButton(ADD);
	}
	
	public void setButton(int cmd) {
		switch (cmd) {
		case ADD:
			btnTotal.setEnabled(false);
			btnAdd.setEnabled(true); //
			btnDel.setEnabled(false);
			btnSearch.setEnabled(false);
			btnCancel.setEnabled(true); //
			this.cmd =ADD;
			break;	
		case DELETE:
			btnTotal.setEnabled(false);
			btnAdd.setEnabled(false);
			btnDel.setEnabled(true); //
			btnSearch.setEnabled(false);
			btnCancel.setEnabled(true); //
			this.cmd =DELETE;
			break;
		case SEARCH:
			btnTotal.setEnabled(false);
			btnAdd.setEnabled(false);
			btnDel.setEnabled(false);
			btnSearch.setEnabled(true); //
			btnCancel.setEnabled(true);//
			this.cmd =SEARCH;
			break;
		case TOTAL:
		case NONE:
		default:
			initText();
		}
	}
	
	public void add() /* throws Exception 트라이캐치 무시하고 진행*/ {
		//System.out.println("추가");
		//private String sqlInsert="insert into customer(code, name, email, tel) values(?,?,?,?)"; 
		try {
			pstmtInsert=conn.prepareStatement(sqlInsert);
			if (txtNo.getText().length()<1 || txtNo.getText()=="") {
				JOptionPane.showMessageDialog(null, "번호는 필수 입니다.");
				return;
			}
			pstmtInsert.setInt(1, Integer.valueOf(txtNo.getText()));
			pstmtInsert.setString(2, txtName.getText());
			pstmtInsert.setString(3, txtEmail.getText());
			pstmtInsert.setString(4, txtTel.getText());
			int re = pstmtInsert.executeUpdate();
			if(re==1) JOptionPane.showMessageDialog(null, "성공");
			else JOptionPane.showMessageDialog(null, "실패");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// sqlDelete = "delete from customer where code=?"
	public void del() {
		// System.out.println("삭제");
		try {
			pstmtDelete=conn.prepareStatement(sqlDelete);
			if(txtNo.getText().length()<1 || txtNo.getText()=="")
			{
				JOptionPane.showMessageDialog(null, "코드를 입력하세요");
				return;
			}
			pstmtDelete.setInt(1, Integer.valueOf(txtNo.getText()));
			int re =pstmtDelete.executeUpdate();
			if(re==1) JOptionPane.showMessageDialog(null, "성공");
			else JOptionPane.showMessageDialog(null, "실패");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void search() {
		try {
			pstmtSearch=conn.prepareStatement(sqlSelect2); //정적인
			pstmtSearchScroll=conn.prepareStatement(sqlSelect2, 
					ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_UPDATABLE); //동적인
			
			if(txtName.getText().length()<1 || txtName.getText()=="") {
				JOptionPane.showMessageDialog(null, "이름을 반드시 입력");
				return;
			}
			pstmtSearch.setString(1, txtName.getText());
			pstmtSearchScroll.setString(1, txtName.getText());
			
			ResultSet rs=pstmtSearch.executeQuery();
			ResultSet rsScroll=pstmtSearchScroll.executeQuery();
			
			if(model==null) model=new MyModel();
			model.getRowCount(rsScroll);
			model.setData(rs);
			
			table.setModel(model);
			table.updateUI();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void total() {
		//System.out.println("전체보기");
		try {
			pstmtTotal=conn.prepareStatement(sqlSelect); // 정적인 문장통
			// 아래내용은 동적인 문장통 (앞으로, 뒤로, 꼭대기 마지막으로 이동할때 사용)
			pstmtTotalScroll=conn.prepareStatement(sqlSelect, 
					ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_UPDATABLE);
		ResultSet rs= pstmtTotal.executeQuery(); // 정적인 결과통
		ResultSet rsScroll= pstmtTotalScroll.executeQuery(); // 동적인 결과통
		
		if(model==null) model=new MyModel();
		model.getRowCount(rsScroll);
		model.setData(rs);
		
		table.setModel(model);
		table.updateUI();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
	
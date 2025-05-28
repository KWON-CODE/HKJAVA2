import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class fDepositOrder implements ActionListener {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTable jtAccountList;
	JButton btnInsertItem,btnSaveItem,btnPrintItem,btnCloseWindow;
	JComboBox jcb1, jcb2, jcb3;

	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="oracle";
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	String sqlSelect="select A_NO, A_ITEM_NAME, C_NO, C_NAME, A_DATE "
			+ " from account a, customer c"
			+ " where a_item_dist='A0' and c.c_no=a.a_c_no ";
	
	// a_item_dist = 'A0' : 계정신청

	String customer_dist[]= {"개인고객","기업고객"};
	Object columnName[] = {"계좌번호", "예금상품명", "고객번호", "고객명", "개설일"};
	Object dataTable[][]=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fDepositOrder window = new fDepositOrder();
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
	public fDepositOrder() {
		initialize();
		initdb();
		initcombo1();
		initcombo3();
	}

	
	public void initdb() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery(sqlSelect);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 973, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("지점");
		lblNewLabel.setBounds(30, 66, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("계좌번호");
		lblNewLabel_1.setBounds(30, 142, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("예금종류");
		lblNewLabel_2.setBounds(30, 178, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("계약기간");
		lblNewLabel_3.setBounds(30, 222, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("고객번호");
		lblNewLabel_4.setBounds(30, 267, 57, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("고객구분");
		lblNewLabel_5.setBounds(30, 99, 57, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		jcb1 = new JComboBox();
		jcb1.setBounds(116, 62, 101, 23);
		frame.getContentPane().add(jcb1);
		// init combo1() : 초기에 db에서 조회해서 지점명을 가져옴
		
		jcb2 = new JComboBox();
		jcb2.setBounds(116, 95, 101, 23);
		frame.getContentPane().add(jcb2);
		
		for(int i=0;i<customer_dist.length;i++) {
			jcb2.addItem(customer_dist[i]);
		}
		
		 jcb3 = new JComboBox();
		jcb3.setBounds(116, 174, 101, 23);
		frame.getContentPane().add(jcb3);
		
		tf1 = new JTextField();
		tf1.setBounds(101, 139, 116, 18);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(101, 219, 116, 21);
		frame.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBounds(101, 264, 116, 21);
		frame.getContentPane().add(tf3);
		tf3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 312, 513, 141);
		frame.getContentPane().add(scrollPane);
		
		jtAccountList = new JTable();
		scrollPane.setViewportView(jtAccountList);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(49, 10, 451, 34);
		frame.getContentPane().add(toolBar);
		
		 
		
		 btnInsertItem = new JButton("");
		btnInsertItem.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\INSERT.GIF"));
		toolBar.add(btnInsertItem);
		
		 btnSaveItem = new JButton("");
		btnSaveItem.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\SAVE.GIF"));
		toolBar.add(btnSaveItem);
		
		 btnPrintItem = new JButton("");
		btnPrintItem.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\PRINT.GIF"));
		toolBar.add(btnPrintItem);
		
		 btnCloseWindow = new JButton("");
		btnCloseWindow.setIcon(new ImageIcon("C:\\java_source\\a250310\\NewBankProject\\src\\TOOLBAR\\EXIT.GIF"));
		toolBar.add(btnCloseWindow);
		
		btnInsertItem.addActionListener(this);
		btnSaveItem.addActionListener(this);
		btnPrintItem.addActionListener(this);
		btnCloseWindow.addActionListener(this);

	
	}

	//액션 구현부분
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInsertItem) {
			btnInsertItem();
			
		} else if (e.getSource()==btnSaveItem){
			btnSaveItem();
			
		}else if (e.getSource()==btnPrintItem){
			btnPrintItem();
			
		}else if (e.getSource()==btnCloseWindow){
			System.exit(0);
			
		}
		
	}

	public void btnPrintItem() {
		
	}

	public void btnSaveItem() {
		
	}

	public void btnInsertItem() {
		
	}
	
	//콤보상자1(jcb1)에 DB에서 (지점코드와 지점명)을 가져옴
	public void initcombo1() {
		String strQuery= "select b_no, b_name from branch";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(strQuery);
			while(rs.next()) {
				jcb1.addItem(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initcombo3() {
		String strQuery= "select item_name from item";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(strQuery);
			while(rs.next()) {
				jcb3.addItem(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JTextArea;

public class swingTest2 {

	private JFrame frame;
	private JTextField textName;
	private JTextField txtEmail;
	private JTextField txtNo;
	private JTextField txtTel;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingTest2 window = new swingTest2();
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
	public swingTest2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 718, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel name = new JLabel("이름");
		name.setBounds(12, 31, 57, 15);
		frame.getContentPane().add(name);
		
		JLabel lblNewLabel = new JLabel("이메일");
		lblNewLabel.setBounds(12, 75, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("번호");
		lblNewLabel_1.setBounds(12, 120, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("전화번호");
		lblNewLabel_2.setBounds(12, 159, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		textName = new JTextField();
		textName.setBounds(58, 28, 116, 21);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(58, 72, 116, 21);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtNo = new JTextField();
		txtNo.setBounds(58, 117, 116, 21);
		frame.getContentPane().add(txtNo);
		txtNo.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setBounds(68, 156, 116, 21);
		frame.getContentPane().add(txtTel);
		txtTel.setColumns(10);
		
		JButton btnTotal = new JButton("전체보기");
		btnTotal.setBounds(12, 232, 97, 23);
		frame.getContentPane().add(btnTotal);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(156, 232, 97, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDel = new JButton("삭제");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDel.setBounds(304, 232, 97, 23);
		frame.getContentPane().add(btnDel);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(440, 232, 97, 23);
		frame.getContentPane().add(btnSearch);
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(568, 232, 97, 23);
		frame.getContentPane().add(btnCancel);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(393, 31, 260, 158);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(423, 49, 217, 125);
		frame.getContentPane().add(textArea);

	}
}

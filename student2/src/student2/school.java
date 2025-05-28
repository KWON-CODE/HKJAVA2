package student2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.ibm.icu.impl.coll.CollationWeights;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class school implements ActionListener {

	private JFrame frame;
	private JTextField hak;
	private JTextField name;
	private JTextField kor;
	private JTextField mat;
	private JTextField eng;
	private JTextField tot;
	private JTextField avg;
	private JButton cal;
	private JButton save;
	private JButton update;

	
	DBConnection db=new DBConnection();
	private JButton delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					school window = new school();
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
	public school() {
		initialize();
		initdb();
		txtinit();
	}

	
	
	public void initdb() {
		try {
			Class.forName(db.driver);
			db.conn=DriverManager.getConnection(db.url,db.user,db.password);
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
		frame.setTitle("\uD559\uC0DD\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		frame.setBounds(100, 100, 639, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		hak = new JTextField();
		hak.setBounds(74, 33, 116, 21);
		frame.getContentPane().add(hak);
		hak.setColumns(10);
		
		name = new JTextField();
		name.setBounds(74, 90, 116, 21);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		kor = new JTextField();
		kor.setBounds(74, 146, 116, 21);
		frame.getContentPane().add(kor);
		kor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uD559\uBC88");
		lblNewLabel.setBounds(5, 36, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(5, 93, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uAD6D\uC5B4");
		lblNewLabel_2.setBounds(5, 149, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC218\uD559");
		lblNewLabel_3.setBounds(5, 210, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC601\uC5B4");
		lblNewLabel_4.setBounds(5, 267, 57, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		mat = new JTextField();
		mat.setBounds(74, 207, 116, 21);
		frame.getContentPane().add(mat);
		mat.setColumns(10);
		
		eng = new JTextField();
		eng.setBounds(74, 264, 116, 21);
		frame.getContentPane().add(eng);
		eng.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uCD1D\uC810");
		lblNewLabel_5.setBounds(404, 36, 57, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		tot = new JTextField();
		tot.setBounds(404, 76, 116, 21);
		frame.getContentPane().add(tot);
		tot.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uD3C9\uADE0");
		lblNewLabel_6.setBounds(404, 129, 57, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		avg = new JTextField();
		avg.setBounds(404, 172, 116, 21);
		frame.getContentPane().add(avg);
		avg.setColumns(10);
		
		
		cal = new JButton("\uC810\uC218\uACC4\uC0B0");
		cal.setBounds(29, 341, 97, 23);
		frame.getContentPane().add(cal);
		
		save = new JButton("DB\uC800\uC7A5");
		save.setBounds(157, 341, 97, 23);
		frame.getContentPane().add(save);
		
		update = new JButton("\uC218\uC815");
		update.setEnabled(false);
		update.setBounds(291, 341, 97, 23);
		frame.getContentPane().add(update);
		
		delete = new JButton("\uC0AD\uC81C");
		delete.setBounds(423, 341, 97, 23);
		frame.getContentPane().add(delete);
		
		cal.addActionListener(this); // 액션추가
		save.addActionListener(this); // 액션 추가
		update.addActionListener(this); // 액션추가
		delete.addActionListener(this); // 액션추가
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==cal) {
			cal();
		} else if (e.getSource()==save){
			save();
		}
		else if(e.getSource()==update) {
			update();
		} else if(e.getSource()== delete) {
			delete();
		}
	}
	
	public void txtinit() {
		hak.setText("");
		name.setText("");
		kor.setText("");
		mat.setText("");
		eng.setText("");
		tot.setText("");
		avg.setText("");
		
		hak.setEditable(true);
		name.setEditable(true);
		kor.setEditable(true);
		mat.setEditable(true);
		eng.setEditable(true);
		tot.setEditable(false);
		avg.setEditable(false);
		save.setEnabled(false); // 저장버튼을 끄기
		update.setEnabled(false);
		
	}
	
	public void cal() {
		if (hak.getText().length()<1 
				&& name.getText().length()<1
				&& kor.getText().length()<1
				&& mat.getText().length()<1
				&& eng.getText().length()<1) {
			// 메시지다이얼로그로 경고창 띄우기
			JOptionPane.showMessageDialog(null, "공백이없습니다.");
			return;
		} else {
		Integer ikor=Integer.valueOf(kor.getText());
		Integer ieng=Integer.valueOf(eng.getText());
		Integer imat=Integer.valueOf(mat.getText());
		Integer itot= ikor + ieng+ imat;
		Double iavg=itot/3.0;
		tot.setText(itot.toString());
		avg.setText(iavg.toString());
		save.setEnabled(true);
		update.setEnabled(true);
		}
	}
	
	public void save() {
	String sqlInsert = 
		"insert into student2(hak, name, kor, eng, mat, tot, avg) values(?,?,?,?,?,?,?)";
	try {
		PreparedStatement pstmt = db.conn.prepareStatement(sqlInsert);
		pstmt.setString(1, hak.getText());
		pstmt.setString(2, name.getText());
		pstmt.setInt(3, Integer.valueOf(kor.getText()));
		pstmt.setInt(4, Integer.valueOf(eng.getText()));
		pstmt.setInt(5, Integer.valueOf(mat.getText()));
		pstmt.setInt(6, Integer.valueOf(tot.getText()));
		pstmt.setDouble(7, Double.valueOf(avg.getText()));
		
		int rs=pstmt.executeUpdate();
		if(rs==1) JOptionPane.showMessageDialog(null, "성공.");
		else JOptionPane.showMessageDialog(null, "실패.");
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public void update() {
		String sqlupdate=
				"update student2 set kor=?, eng=?, mat=?, tot=?, avg=? where hak=?"; // 안에 update 문법 넣기
		String sqlselect="select count(*) from student2 where hak =? and name=?";
				
		try {
			String shak = hak.getText();
			String sname = name.getText();
			int ikor=Integer.valueOf(kor.getText());
			int ieng=Integer.valueOf(eng.getText());
			int imat=Integer.valueOf(mat.getText());
			int itot=Integer.valueOf(tot.getText());
			double iavg=Double.valueOf(avg.getText());
			/////////////////////////////////////////////////////////////////////
			PreparedStatement pstmtsel = db.conn.prepareStatement(sqlselect);
			pstmtsel.setString(1, shak);
			pstmtsel.setString(2, sname);
			ResultSet rs= pstmtsel.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			if(count<1) {
				JOptionPane.showMessageDialog(null, "동일한 학번 없음");
				return;
			} else {
				
			//////////////////////////////////////////////////////////////////////////////////
			PreparedStatement pstmt=db.conn.prepareStatement(sqlupdate);
			pstmt.setInt(1, ikor);
			pstmt.setInt(2, Integer.valueOf(eng.getText()));
			pstmt.setInt(3, Integer.valueOf(mat.getText()));
			pstmt.setInt(4, Integer.valueOf(tot.getText()));
			pstmt.setDouble(5, Double.valueOf(avg.getText()));
			pstmt.setString(6, hak.getText());
			int re = pstmt.executeUpdate();
			if (re>=1) JOptionPane.showMessageDialog(null, "업데이트");
			else JOptionPane.showMessageDialog(null, "업데이트 실패");
			txtinit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		String sqlselect="select count(*) from student2 where hak=? and name=?";
		String sqldelete="delete from student2 where hak=?";
		try {
			String shak=hak.getText();
			String sname=name.getText();
			int ikor=Integer.valueOf(kor.getText());
			int ieng=Integer.valueOf(eng.getText());
			int imat=Integer.valueOf(mat.getText());
			int itot=Integer.valueOf(tot.getText());
			double iavg=Double.valueOf(avg.getText());
			
			//////동일한 학번과 이름이 존재하는지 조회/////////////////////////////////////////////
			PreparedStatement pstmtsel=db.conn.prepareStatement(sqlselect);
			pstmtsel.setString(1,shak);
			pstmtsel.setString(2,sname);
			ResultSet rs=pstmtsel.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			if(count<1) {
				JOptionPane.showMessageDialog(null, "동일한 학번이 없음");
				return;
			}
			//////////////////////////////////////////////////////////////////////////
			else {
				PreparedStatement pstmtdel=db.conn.prepareStatement(sqldelete);
				pstmtdel.setString(1, shak);
				int re=pstmtdel.executeUpdate();
				if (re>=1) JOptionPane.showMessageDialog(null, "삭제성공");
				else JOptionPane.showMessageDialog(null, "삭제실패");
				txtinit(); // 모든텍스트필드 지움
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

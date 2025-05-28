package miniProject;

import java.awt.EventQueue;
import java.awt.TextArea; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class branch {

    private JFrame frame;
    private JTextField tf1; 
    private JTextField tf2; 
    private JTextField tf3;
    private JTextField tf4; 
    private JTextField tf5; 

    private JButton btnInsert; 
    private JButton btnSave;  
    private JButton btnCancel; 
    private TextArea textArea; 

   
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
    private static final String DB_USER = "system"; 
    private static final String DB_PASSWORD = "oracle"; 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Class.forName("oracle.jdbc.driver.OracleDriver");
                	  branch window = new branch();  
                	  window.frame.setVisible(true);
                } catch (ClassNotFoundException cnfe) {
                    JOptionPane.showMessageDialog(null, "Oracle JDBC 드라이버를 찾을 수 없습니다.\n" + cnfe.getMessage(), "드라이버 오류", JOptionPane.ERROR_MESSAGE);
                    cnfe.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public branch() {
        initialize();
        addListeners(); 
    }

    /**
     * 데이터베이스 연결을 가져옵니다.
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("지점관리");
        frame.setBounds(100, 100, 680, 603); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); 

        JLabel lblBNo = new JLabel("지점번호");
        lblBNo.setBounds(12, 56, 70, 15);
        frame.getContentPane().add(lblBNo);

        tf1 = new JTextField(); 
        tf1.setBounds(94, 53, 180, 21); 
        frame.getContentPane().add(tf1);
        tf1.setColumns(10);

        JLabel lblBName = new JLabel("지점명");
        lblBName.setBounds(12, 109, 70, 15);
        frame.getContentPane().add(lblBName);

        tf2 = new JTextField(); 
        tf2.setBounds(94, 106, 180, 21); 
        frame.getContentPane().add(tf2);
        tf2.setColumns(10);

        JLabel lblBAddr = new JLabel("주소");
        lblBAddr.setBounds(12, 165, 70, 15);
        frame.getContentPane().add(lblBAddr);

        tf3 = new JTextField(); 
        tf3.setBounds(94, 162, 300, 21); 
        frame.getContentPane().add(tf3);
        tf3.setColumns(10);

        JLabel lblBPhone = new JLabel("전화번호");
        lblBPhone.setBounds(12, 222, 70, 15);
        frame.getContentPane().add(lblBPhone);

        tf4 = new JTextField(); 
        tf4.setBounds(94, 219, 180, 21); 
        frame.getContentPane().add(tf4);
        tf4.setColumns(10);

        JLabel lblBAssets = new JLabel("자산총액");
        lblBAssets.setBounds(12, 273, 70, 15);
        frame.getContentPane().add(lblBAssets);

        tf5 = new JTextField(); 
        tf5.setBounds(94, 270, 180, 21); 
        frame.getContentPane().add(tf5);
        tf5.setColumns(10);

        
        btnInsert = new JButton("추가");
        btnInsert.setBounds(62, 23, 97, 23); 
        frame.getContentPane().add(btnInsert);

        btnSave = new JButton("저장");
        btnSave.setBounds(181, 23, 97, 23); 
        frame.getContentPane().add(btnSave);

        btnCancel = new JButton("취소");
        btnCancel.setBounds(300, 23, 97, 23); 
        frame.getContentPane().add(btnCancel);

        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 311, 640, 222); 
        frame.getContentPane().add(scrollPane);

        textArea = new TextArea(); 
        textArea.setEditable(false); 
        scrollPane.setViewportView(textArea);
    }

    /**
     * 버튼에 대한 이벤트 리스너를 추가합니다.
     */
    private void addListeners() {
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertBranch();
            }
        });

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateBranch();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    /**
     * 입력 필드를 모두 지웁니다. (취소 버튼 기능)
     */
    private void clearFields() {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        textArea.append("입력 필드가 초기화되었습니다.\n");
    }

    /**
     * 지점 정보를 DB에 추가합니다. (추가 버튼 기능)
     */
    private void insertBranch() {
        String bNo = tf1.getText().trim();
        String bName = tf2.getText().trim();
        String bAddr = tf3.getText().trim();
        String bPhone = tf4.getText().trim();
        String bAssetsStr = tf5.getText().trim();

        
        if (bNo.isEmpty() || bName.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "지점번호와 지점명은 필수 입력 항목입니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            textArea.append("추가 실패: 지점번호 또는 지점명 누락\n");
            return;
        }
       
        if (bNo.length() > 3) {
             JOptionPane.showMessageDialog(frame, "지점번호는 3자리를 넘을 수 없습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
             textArea.append("추가 실패: 지점번호 길이 초과 (최대 3자리)\n");
             return;
        }

        BigDecimal bAssets;
        try {
            if (bAssetsStr.isEmpty()) {
                bAssets = null; 
            } else {
                bAssets = new BigDecimal(bAssetsStr);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "자산총액은 숫자 형식이어야 합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            textArea.append("추가 실패: 자산총액 숫자 형식 오류\n");
            return;
        }

        String sql = "INSERT INTO branch (b_no, b_name, b_addr, b_phone, b_assets) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, bNo);
            pstmt.setString(2, bName);
            pstmt.setString(3, bAddr.isEmpty() ? null : bAddr); 
            pstmt.setString(4, bPhone.isEmpty() ? null : bPhone); 
            if (bAssets == null) {
                pstmt.setNull(5, java.sql.Types.DECIMAL);
            } else {
                pstmt.setBigDecimal(5, bAssets);
            }

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                textArea.append("지점 정보 추가 성공: " + bNo + " - " + bName + "\n");
                JOptionPane.showMessageDialog(frame, "지점 정보가 성공적으로 추가되었습니다.", "추가 성공", JOptionPane.INFORMATION_MESSAGE);
              
            } else {
                textArea.append("지점 정보 추가 실패.\n");
                JOptionPane.showMessageDialog(frame, "지점 정보 추가에 실패했습니다.", "추가 실패", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
           
            if (ex.getErrorCode() == 1) { 
                 JOptionPane.showMessageDialog(frame, "이미 존재하는 지점번호입니다.", "추가 실패", JOptionPane.ERROR_MESSAGE);
                 textArea.append("추가 실패: 중복된 지점번호 (" + bNo + ")\n");
            } else {
                textArea.append("DB 오류 (추가): " + ex.getMessage() + "\n");
                JOptionPane.showMessageDialog(frame, "데이터베이스 오류 발생: " + ex.getMessage(), "DB 오류", JOptionPane.ERROR_MESSAGE);
            }
            ex.printStackTrace();
        }
    }

    private void updateBranch() {
        String bNo = tf1.getText().trim();
        String bName = tf2.getText().trim();
        String bAddr = tf3.getText().trim();
        String bPhone = tf4.getText().trim();
        String bAssetsStr = tf5.getText().trim();

    
        if (bNo.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "수정할 지점번호는 필수 입력 항목입니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            textArea.append("수정 실패: 지점번호 누락\n");
            return;
        }
       
        if (bName.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "지점명은 필수 입력 항목입니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            textArea.append("수정 실패: 지점명 누락\n");
            return;
        }

        BigDecimal bAssets;
        try {
            if (bAssetsStr.isEmpty()) {
                bAssets = null;
            } else {
                bAssets = new BigDecimal(bAssetsStr);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "자산총액은 숫자 형식이어야 합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            textArea.append("수정 실패: 자산총액 숫자 형식 오류\n");
            return;
        }

     
        String sql = "UPDATE branch SET b_name = ?, b_addr = ?, b_phone = ?, b_assets = ? WHERE b_no = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, bName);
            pstmt.setString(2, bAddr.isEmpty() ? null : bAddr);
            pstmt.setString(3, bPhone.isEmpty() ? null : bPhone);
            if (bAssets == null) {
                pstmt.setNull(4, java.sql.Types.DECIMAL);
            } else {
                pstmt.setBigDecimal(4, bAssets);
            }
            pstmt.setString(5, bNo); 

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                textArea.append("지점 정보 수정 성공: " + bNo + "\n");
                JOptionPane.showMessageDialog(frame, "지점 정보가 성공적으로 수정되었습니다.", "수정 성공", JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                textArea.append("지점 정보 수정 실패 (해당 지점번호 없음 또는 변경 내용 없음): " + bNo + "\n");
                JOptionPane.showMessageDialog(frame, "수정할 지점 정보를 찾을 수 없거나 변경된 내용이 없습니다.", "수정 실패", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            textArea.append("DB 오류 (수정): " + ex.getMessage() + "\n");
            JOptionPane.showMessageDialog(frame, "데이터베이스 오류 발생: " + ex.getMessage(), "DB 오류", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
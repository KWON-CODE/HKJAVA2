package session09.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx=new InitialContext();
			Context envContext=(Context)ctx.lookup("java:/comp/env");
			dataFactory=(DataSource)envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMember() throws SQLException {
		//connDB();
		con=dataFactory.getConnection();
		
		List<MemberVO> list=new ArrayList<MemberVO>();
		
		String sql="select * from t_member";
		ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			String id=rs.getString("id");
			String pwd=rs.getString("pwd");
			String name=rs.getString("name");
			String email=rs.getString("email");
			String joinDate=rs.getString("joinDate");
			
			MemberVO memberVO=new MemberVO();
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			memberVO.setJoinDate(joinDate);
			
			list.add(memberVO);
			
		}
		rs.close();
		ps.close();
		con.close();
		
		return list;
		
	}
	public void addMember(MemberVO vo) {
		try {
			con=dataFactory.getConnection();
			
			String id=vo.getId();
			String pwd=vo.getPwd();
			String name=vo.getName();
			String email=vo.getEmail();
						
			String query="insert into t_member";
			query+="(id,pwd,name,email)";
			query+=" values(?,?,?,?)";
			
			System.out.println("preparedStatement:"+query);
			ps=con.prepareStatement(query);
			
			ps.setString(1,id);
			ps.setString(2, pwd);
			ps.setString(3,name);
			ps.setString(4, email);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public int delMember(String id) {
		int result=0;
		try {
			con=dataFactory.getConnection();
			//쿼리
			String query="delete from t_member where id=?";
			ps=con.prepareStatement(query);
			//자리 채움(?)에 해당되는 값을 대입
			ps.setString(1, id);
			result=ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public void connDB() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Oracle 드라이브 로딩 성공!!!");
			con=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Connection 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean isExisted(MemberVO mVO) {
		String id=mVO.getId();
		String pwd=mVO.getPwd();
		
		try {
			con=dataFactory.getConnection();
			String query="select decode(count(*),1,'true','false')";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

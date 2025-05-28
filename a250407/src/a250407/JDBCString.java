package a250407;

import java.sql.*;


public class JDBCString {
	protected static String driver="oracle.jdbc.OracleDriver";
	protected static String url="jdbc:oracle:thin:@localhost:1521:xe";
	protected static String user="system";
	protected static String password="oracle";
	protected static String sqlInsert="insert into member(code, name, id, pwd, age) values(?,?,?,?,?)"; 
	protected static String sqlSelect="select  * from member";
	protected static String sqlUpdate="update member set pwd=? where name=?";
	protected static String sqlDelete="delete from member where id=? ";
	protected static Connection conn=null;
	protected static PreparedStatement pstmt=null;
}

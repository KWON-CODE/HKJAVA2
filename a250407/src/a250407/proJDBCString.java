package a250407;

import java.sql.*;


public class proJDBCString {
	protected static String driver="oracle.jdbc.OracleDriver";
	protected static String url="jdbc:oracle:thin:@localhost:1521:xe";
	protected static String user="system";
	protected static String password="oracle";
	protected static String sqlInsert="insert into customer(code, name, email, tel) values(?,?,?,?)"; 
	protected static String sqlSelect="select * from  customer";
	protected static String sqlUpdate="update customer set email=? where code=?";
	protected static String sqlDelete="delete customer where code=? ";
	protected static Connection conn=null;
	protected static PreparedStatement pstmt=null;
}

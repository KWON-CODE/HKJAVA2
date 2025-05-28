package student2;

import java.sql.Connection;

public class DBConnection {
	protected String driver="oracle.jdbc.OracleDriver";
	protected String user="system";
	protected String password="oracle";
	protected String url="jdbc:oracle:thin:@localhost:1521:xe";
	protected Connection conn=null;
}

package DBPKG;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class DBOpen {
	public static Connection getConnetion() throws Exception{
		//static -> Ŭ���������� ���� ���� �����ϴ�.

		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = DriverManager.getConnection ("jdbc:mariadb://127.0.0.1:3306/pinetree?useUnicode=true&characterEncoding=euck","root","1234");
		return con;		
	}
}

package model;
import java.sql.*;
public class GetCon {
private GetCon() {}

public static Connection con;
	static {
		try {
			Class.forName(DBinitializer.driver);
			con = DriverManager.getConnection(DBinitializer.url,DBinitializer.serverName,DBinitializer.serverPwd);
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			
			System.out.println("Exception in GetCon");
		}
	}
	
public static Connection getCon() {
	return con;
}
	


}

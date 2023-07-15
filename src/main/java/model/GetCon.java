package model;
import java.sql.*;
public class GetCon {
private GetCon() {}

public static Connection getCon() 
 {
	Connection con = null;
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
		return con;
	}
	
}

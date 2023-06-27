package model;
import java.sql.*;
public class VerifyLogin {

	public static boolean checkLogin(String userName, String password ) {
		boolean status = false;
		
		Connection con = GetCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("Select username, password from userdata where username =? and password =?");
			ps.setString(1, userName);
			ps.setString(2, userName);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
}

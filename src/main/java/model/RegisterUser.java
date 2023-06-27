package model;
import java.sql.*;
public class RegisterUser {
	static int status = 0;
	
	public static int register(String userid,String username,String password,String name,Integer account_number,String ifsc,String pan_card,Integer	 phone_number,String emailid,Integer current_balance) {
		
		Connection con = GetCon.getCon();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("INSERT INTO USERDATA VALUES (?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(2,username);
			ps.setString(3,password);
			ps.setString(4,name);
			ps.setInt(5,account_number);
			ps.setString(6,ifsc);
			ps.setString(7,pan_card);
			ps.setInt(8,phone_number);
			ps.setString(9,emailid);
			ps.setInt(10,current_balance);
			
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}

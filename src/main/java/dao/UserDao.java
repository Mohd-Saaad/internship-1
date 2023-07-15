package dao;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.*;
public class UserDao {
	
	String insertUser = "insert into userdata" + "(username,password,name,account_number,ifsc,pan_card,phone_number,emailid,current_balance) values" + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String selectUser = "select username,password,name,account_number,ifsc,pan_card,phone_number,emailid,current_balance from userdata where username = ?";
	String updateUser = "insert into userdata" + "(username,password,name,account_number,ifsc,pan_card,phone_number,emailid,current_balance) values" + "(?, ?, ?, )";
	String delUser= "insert into userdata" + "(username,name,account_number,ifsc,pan_card,phone_number,emailid,current_balance) values" + "(?, ?, ?, )";
	
	PrintWriter out = new PrintWriter(System.out);

//	Register new User
	
	 public boolean registerUser(UserData user) throws ClassNotFoundException{
		
		boolean result = false;
		
		try{
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/online_banking", "postgres","dbuser");
			PreparedStatement ps;
			
			ps = con.prepareStatement(insertUser);
			
			ps.setString(2,user.getUsername());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getName());
			ps.setInt(5,(user.getAccount_number()));
			ps.setString(6,user.getIfsc());
			ps.setString(7,user.getPan_card());
			ps.setInt(8,(user.getPhone_number()));
			ps.setString(9,user.getEmailid());
			ps.setInt(10,(user.getCurrent_balance()));
			
			result = ps.executeUpdate()> 0;
			
			if(result){
				out.println("Regestration done succesfully...");
			}
			else{

				out.println("Regestration failed...");
			}
		}catch(Exception e){
			out.println(e);
		}		
		
		
	return result;
	}
	
//	Select user by ID
	
	public UserData selectUser( Integer id ) {
		UserData user = null;
		try{
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/online_banking", "postgres","dbuser");
			PreparedStatement ps;
			
			ps = con.prepareStatement(selectUser);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				id = rs.getInt("userid");
				String uname = rs.getString("uname");
				String name = rs.getString("name");
				String pass = rs.getString("password");
				Integer acNum = rs.getInt("account_number");
				String ifsc = rs.getString("ifsc");
				String pan = rs.getString("pan_card");
				Integer phNum = rs.getInt("phone_number");
				String email = rs.getString("emailid");
				Integer currBal = rs.getInt("current_balance");
				user = new UserData(id,uname,name,pass,acNum,ifsc,pan,phNum,email,currBal);
			}
		}catch(Exception e){
			out.println(e);
		}			

		return user;
	}
//	Select all the Users
	public List<UserData> selectAllUser( ) {

		List<UserData> users = new ArrayList<UserData>();
		
		try{
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/online_banking", "postgres","dbuser");
			PreparedStatement ps;
			
			ps = con.prepareStatement(selectUser);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Integer id = rs.getInt("userid");
				String uname = rs.getString("username");
				String name = rs.getString("name");
				String pass = rs.getString("password");
				Integer acNum = rs.getInt("account_number");
				String ifsc = rs.getString("ifsc");
				String pan = rs.getString("pan_card");
				Integer phNum = rs.getInt("phone_number");
				String email = rs.getString("emailid");
				Integer currBal = rs.getInt("current_balance");
				users.add( new UserData(id,uname,name,pass,acNum,ifsc,pan,phNum,email,currBal));
			}
		}catch(Exception e){
			out.println(e);
		}			

		return users;
	}
//	Delete User
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDel ;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/online_banking", "postgres","dbuser");
		PreparedStatement ps;
		
		ps = con.prepareStatement(delUser);
		
		ps.setInt(1, id);
		rowDel = ps.executeUpdate()>0;
		
		return rowDel;
	}
}

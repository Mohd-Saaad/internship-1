package dao;
import java.sql.*;
public class customerDao {
	public int RegisterUser(customerData customer) throws ClassNotFoundException{
		String userSQL = "insert into userdata" + "(userid,username,name,account_number,ifsc,pan_card,phone_number,emailid,current_balance) values" + "(?, ?, ?, )";
	}
}

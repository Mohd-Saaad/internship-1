<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%  String username = request.getParameter("username"); 
	String name = request.getParameter("name"); 
	String emailid = request.getParameter("emailid");
	Integer phone_number = Integer.parseInt(request.getParameter("phone_number"));
	String ifsc= request.getParameter("ifsc");
	String aadhar = request.getParameter("aadhar");
	String pan_card = request.getParameter("pan_card"); 
	String password = request.getParameter("password");
	Integer current_balance = Integer.parseInt(request.getParameter("current_balance")); 
	Integer account_number = Integer.parseInt(request.getParameter("account_number")) ; 
	
	try{
		Class.forName("org.postgresql.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/online_banking", "postgres","adminuser");
		PreparedStatement ps;
		
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
		
		int status = ps.executeUpdate();
		if(status > 0 ){
			out.println("Regestration done succesfully...");
		}
		else{

			out.println("Regestration failed...");
		}
	}catch(Exception e){
		out.println(e);
	}
	
%>









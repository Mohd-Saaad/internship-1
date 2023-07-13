<%@ page import = "java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String username = request.getParameter("username"); 
	String name = request.getParameter("name"); 
	String ifscCode= request.getParameter("ifscCode");
	String accNo = request.getParameter("accNo");
	
	try{
		Class.forName("org.postgresql.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/online_banking", "postgres","adminuser");
		PreparedStatement ps;
		
		ps = con.prepareStatement("INSERT INTO PAYEE VALUES (?,?,?,?,?,?,?,?,?,?)");
		
		ps.setString(2,accNo);
		ps.setString(3,name);
		ps.setString(4,ifscCode);
		
		
		int status = ps.executeUpdate();
		if(status > 0 ){
			out.println("Regestration of Payee done succesfully...");
		}
		else{

			out.println("Regestration of Payee failed...");
		}
	}catch(Exception e){
		out.println(e);
	} %>
    
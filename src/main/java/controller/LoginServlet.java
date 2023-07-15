package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DBinitializer;
import model.VerifyLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
//		boolean status = VerifyLogin.checkLogin(uname, pass);
//		PrintWriter out = response.getWriter();
//		if(status) {
//			out.print("Success");
//		}
//		else {
//			out.print("Try again fail agian fail better");
//		}
		
		try {
			Class.forName(DBinitializer.driver);
			Connection con = DriverManager.getConnection(DBinitializer.url,DBinitializer.serverName,DBinitializer.serverPwd);
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			PreparedStatement ps = con.prepareStatement("Select username, password from userdata where username =? and password =?");
			ps.setString(2, uname);
			ps.setString(3, pass);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
//				RequestDispatcher rd = request.getRequestDispatcher("payee.jsp");
//				rd.forward(request, response);
 			out.println("<html>");
				out.println("<body>");

				out.println("<h1>" +"Result is: "+rs+"</h1>");
				out.println("</body>");

				out.println("</html>");			
			}
			else {
				out.println("<html>");
				out.println("<body>");

				out.println("<h1>" +"Result is: "+rs+"</h1>");
				out.println("</body>");
				out.println("</html>");		
			}
//			
		} catch (Exception e) {
			e.printStackTrace();
}
//		
//		if(res) {
//			
//		}
//		else {
//			out.print("Login failed");
//		}

	}
}


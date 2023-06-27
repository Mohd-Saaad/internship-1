package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.customerData;

import java.io.IOException;

import dao.customerDao;

/**
 * Servlet implementation class customerServlet
 */
public class customerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private customerDao cD = new customerDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userID = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String account_number = request.getParameter("account_number");
		String ifsc = request.getParameter("ifsc");
		String pan_card = request.getParameter("pan_card");
		String phone_number = request.getParameter("phone_number");
		String emailid = request.getParameter("emailid");
		String current_balance = request.getParameter("current_balance");
		
		customerData cData = new customerData();
		
		cData.setUserid(userID);
		cData.setUsername(username);
		cData.setPassword(password);
		cData.setName(name);
		cData.setAccount_number(account_number);
		cData.setIfsc(ifsc);
		cData.setPan_card(pan_card);
		cData.setPhone_number(phone_number);
		cData.setEmailid(emailid);
		cData.setCurrent_balance(current_balance);
	
		try {
			cD.RegisterUser(cData);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("");
		
	}	
	}		
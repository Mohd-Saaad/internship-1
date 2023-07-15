package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserData;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.UserDao;

/**
 * Servlet implementation class customerServlet
 */
@WebServlet("/register")
public class customerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao;
	
	public customerServlet() {
		this.userDao = new UserDao();
	}
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();
		switch (action) {
		
		case "/new":
			show(request, response);
			break;
			
		case "/insert":
			try {
				insert(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		case "/delete":
			try {
				delUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "/update":
			update(request, response);
			
		default:
			list(request, response);
		}
	}
	
	private static void show(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("");
		rd.forward(req, res);
	}
	
	private static void insert(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, IOException {
		Integer id = Integer.parseInt(req.getParameter("userid"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		Integer account_number =Integer.parseInt(req.getParameter("account_number"));
		String ifsc = req.getParameter("ifsc");
		String pan_card = req.getParameter("pan_card");
		Integer phone_number = Integer.parseInt(req.getParameter("phone_number"));
		String emailid = req.getParameter("emailid");
		Integer current_balance = Integer.parseInt(req.getParameter("current_balance"));
		
		UserData newUser = new UserData(id,username,name,password,account_number,ifsc,pan_card,phone_number,emailid,current_balance);
		
		userDao.registerUser(newUser);
		res.sendRedirect("list");
	}
	private static void delUser(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		Integer id = Integer.parseInt(req.getParameter("userid"));
		userDao.deleteUser(id);
	}
	private static void update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("userid"));
		UserData existingUser = userDao.selectUser(id);
		RequestDispatcher rd = req.getRequestDispatcher("");
		req.setAttribute("user", existingUser);
		rd.forward(req, res);
	}
	
//	List
	private static void list(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<UserData> listUser = userDao.selectAllUser();
		req.setAttribute("listUser", listUser);
		RequestDispatcher rd = req.getRequestDispatcher("");
		rd.forward(req, res);
	}
}		
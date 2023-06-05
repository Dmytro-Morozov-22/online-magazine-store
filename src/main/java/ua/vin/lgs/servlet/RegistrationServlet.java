package ua.vin.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.vin.lgs.domain.User;
import ua.vin.lgs.domain.UserRole;
import ua.vin.lgs.service.UserService;
import ua.vin.lgs.service.impl.UserServiceImpl;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		if(!firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty() && !email.isEmpty()) {
			userService.create(new User(firstName, lastName, email, password, UserRole.USER.toString()));
//			System.out.println("-if-");
		}
		
		HttpSession session = req.getSession(true);
		session.setAttribute("userData", firstName);
		
		
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("Success");
//		req.getRequestDispatcher("cabinet.jsp").forward(req, resp);

	}

}

package com.Servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.UserService;
import com.user.UserDTO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(firstname + "  " + lastname + " " + email + "  " + password);
		String errMsg = null;

		boolean isValied = true;

		if (firstname == null || firstname.isEmpty() || firstname.isBlank()) {

			errMsg = errMsg + "Please enter " + " first Name";
			isValied = false;

		}
		if (lastname == null || lastname.isEmpty() || lastname.isBlank()) {

			errMsg = errMsg + "Please enter " + "last Name";
			isValied = false;

		}
		if (email == null || email.isEmpty() || email.isBlank()) {

			errMsg = errMsg + "Please enter " + " email";
			isValied = false;

		}
		if (password == null || password.isEmpty() || password.isBlank()) {

			errMsg = errMsg + "Please enter " + " password";
			isValied = false;

		}

		if (isValied) {

			UserDTO user = new UserDTO();

			String userName = firstname + lastname;

			user.setName(userName);
			user.setEmail_id(email);
			user.setPassword(password);

			UserService userService = new UserService();
			boolean isUserCreated = userService.createuser(user);

			if (!isUserCreated) {

				isUserCreated = true;

				request.setAttribute("isUserCreated", isUserCreated);
				request.setAttribute("userCreated", "User Created Successfully.....");
				request.getRequestDispatcher("Signin.jsp").forward(request, response);

			}

		} else {
			request.setAttribute("errmsg", errMsg);
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		}

	}
}
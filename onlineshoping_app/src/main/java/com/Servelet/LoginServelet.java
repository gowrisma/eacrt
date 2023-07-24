package com.Servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.CartService;
import com.Service.UserService;
import com.user.CartDto;
import com.user.UserDTO;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean isLoggedIn = false;

		String email = request.getParameter("email");
		String pwd = request.getParameter("password");

		UserService userService = new UserService();

		UserDTO user = userService.getUser(email, pwd);

		if (user != null) {

			CartService cartService = new CartService();

			List<CartDto> userCartList = cartService.getCartListbyUserid(user.getEmail_id());

			request.getSession().setAttribute("user", user);

			request.getSession().setAttribute("cartlist", userCartList);
			request.getRequestDispatcher("allProducts").forward(request, response);
		} else {
			isLoggedIn = true;
			request.setAttribute("isLoggedIn", isLoggedIn);
			request.getRequestDispatcher("Signin.jsp").forward(request, response);
		}
	}

}

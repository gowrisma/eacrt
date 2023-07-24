package com.Servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.CartService;
import com.user.CartDto;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
		List<CartDto> cartList = (List<CartDto>) request.getSession().getAttribute("cartlist");

		CartService cartService = new CartService();

		List<CartDto> cartlist = cartService.getAllProductsFromCart(cartList);
		System.out.println("cartlist.."+cartlist);
		double totalPrice = 0.0;
		for (CartDto dto : cartlist) {
			totalPrice = totalPrice + dto.getPrice();
		}

		request.getSession().setAttribute("cart_list", cartlist);
		request.setAttribute("totalPrice", totalPrice);
		request.getRequestDispatcher("cart.jsp").forward(request, response);

	}

}

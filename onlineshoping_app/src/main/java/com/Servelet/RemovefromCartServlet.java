package com.Servelet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.CartDto;

/**
 * Servlet implementation class RemovefromCartServlet
 */
@WebServlet("/remove-from-cart")
public class RemovefromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemovefromCartServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));

		int removeIndex = 0;

		for (CartDto dto : cartList) {

			if (dto.getId() == id) {
				removeIndex = cartList.indexOf(dto);
			}
		}
		cartList.remove(removeIndex);
		request.getSession().setAttribute("cartlist", cartList);

		request.getRequestDispatcher("Cartservlet").forward(request, response);

	}

}

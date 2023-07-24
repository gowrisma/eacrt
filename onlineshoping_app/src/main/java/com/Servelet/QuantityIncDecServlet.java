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
 * Servlet implementation class QuantityIncDecServlet
 */
@WebServlet("/quantity-inc-dec")
public class QuantityIncDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuantityIncDecServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = req.getParameter("action");

		int id = Integer.parseInt(req.getParameter("id"));

		System.out.println(action);

		List<CartDto> cartList = (List<CartDto>) req.getSession().getAttribute("cartlist");

		int productIndex = 0;

		for (CartDto dto : cartList) {
			if (dto.getId() == id) {
				productIndex = cartList.indexOf(dto);
			}
		}

		if (action.equals("inc")) {

			CartDto newDto = cartList.get(productIndex);
			int quantity = newDto.getQuantity();
			cartList.remove(productIndex);
			newDto.setQuantity(quantity + 1);
			cartList.add(productIndex, newDto);

		} else {
			CartDto newDto = cartList.get(productIndex);
			int quantity = newDto.getQuantity();
			cartList.remove(productIndex);
			if (quantity > 1) {
				newDto.setQuantity(quantity - 1);
				cartList.add(productIndex, newDto);
			}
			if (quantity == 1) {
				newDto.setQuantity(quantity);
				cartList.add(productIndex, newDto);
			}

		}
		req.getSession().setAttribute("cartlist", cartList);
		req.getRequestDispatcher("CartServlet").forward(req, res);

	}

}

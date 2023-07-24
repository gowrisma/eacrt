package com.Servelet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.CartDto;
import com.user.UserDTO;

/**
 * Servlet implementation class AddtocartServlet
 */
@WebServlet("/addtocart")
public class AddtocartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddtocartServlet() {
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

		int id = Integer.parseInt((request.getParameter("id")));

		List<CartDto> newcartlist = new ArrayList<>();

		List<CartDto> oldcartlist = (List<CartDto>) request.getSession().getAttribute("cartlist");
		UserDTO user = (UserDTO) request.getSession().getAttribute("user");

		System.out.println("oldcart..." + oldcartlist);

		if (oldcartlist != null) {
			newcartlist = oldcartlist;
			System.out.println("oldcart..." + oldcartlist);
			for (CartDto dto : newcartlist) {
				if (dto.getId() == id) {
					System.out.println(dto.getId() + "" + id);
					request.getRequestDispatcher("Productexists.jsp").forward(request, response);

				}
			}

			CartDto dto = new CartDto();
			dto.setId(id);
			dto.setQuantity(1);
			dto.setUserid(user.getEmail_id());
			newcartlist.add(dto);
			request.getSession().setAttribute("cartlist", newcartlist);
			request.getRequestDispatcher("allProducts").forward(request, response);

		} else {
			CartDto dto = new CartDto();
			dto.setId(id);
			dto.setQuantity(1);
			dto.setUserid(user.getEmail_id());
			newcartlist.add(dto);
			request.getSession().setAttribute("cartlist", newcartlist);
			request.getRequestDispatcher("allProducts").forward(request, response);
		}
		System.out.println("newlist..." + newcartlist);

	}

}

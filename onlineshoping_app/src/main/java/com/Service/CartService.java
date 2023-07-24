package com.Service;

import java.util.List;

import com.Dao.CartDao;
import com.user.CartDto;
import com.user.UserDTO;

public class CartService {

	private CartDao dao;

	public CartService() {
		dao = new CartDao();

	}

	public List<CartDto> getAllProductsFromCart(List<CartDto> cartList) {

		return dao.getAllProductsFromCart(cartList);

	}

	public List<CartDto> getCartListbyUserid(String userid) {
		return dao.getAllCartListByUserId(userid);
	}

	public void insertProductsInCart(List<CartDto> cartList) {
		dao.insertProductsInCart(cartList);
	}
}

package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DBConnection.DBCon;
import com.user.CartDto;

public class CartDao {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;

	public List<CartDto> getAllProductsFromCart(List<CartDto> cartList) {

		List<CartDto> cartProducts = new ArrayList<CartDto>();

		try {
			con = DBCon.getconnection();
			stmt = con.createStatement();

			for (CartDto dto : cartList) {
				String query_allProductsby_id = "select * from product where id=" + dto.getId();
				rs = stmt.executeQuery(query_allProductsby_id);
				while (rs.next()) {
					CartDto cartDto = new CartDto();
					cartDto.setId(rs.getInt(1));
					cartDto.setName(rs.getString(2));
					cartDto.setCategory(rs.getString(3));
					cartDto.setQuantity(dto.getQuantity());

					double price = rs.getDouble(4);
					double productPrice = price * dto.getQuantity();
					cartDto.setPrice(productPrice);

					cartProducts.add(cartDto);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cartProducts;

	}


	public List<CartDto> getAllCartListByUserId(String userId) {

		List<CartDto> cartList = new ArrayList<CartDto>();

		try {
			String query_cartList = "select * from cart where userid= " + "'" + userId + "'";
			con = DBCon.getconnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_cartList);
			while (rs.next()) {
				CartDto dto = new CartDto();
				dto.setQuantity(rs.getInt(2));
				dto.setId(rs.getInt(3));
				dto.setUserid(rs.getString(4));
				cartList.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cartList);
		return cartList;

	}

	public void insertProductsInCart(List<CartDto> cartList) {

		for (CartDto dto : cartList) {
			System.out.println(dto.getUserid());
			String query_cartList = "select * from cart where id = " + dto.getCartid();

			try {

				con = DBCon.getconnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(query_cartList);
				if (!rs.next()) {

					String SQL_INSERT = "INSERT INTO cart (quantity, pid, userid) VALUES (?,?,?)";

					ps = con.prepareStatement(SQL_INSERT);
					ps.setInt(1, dto.getQuantity());
					ps.setInt(2, dto.getId());
					ps.setString(3, dto.getUserid());
					ps.executeUpdate();

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
		
	public void removefromcartlistusingPId(Integer pid){
		
		
		
		
	}
}
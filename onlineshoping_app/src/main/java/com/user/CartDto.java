package com.user;

public class CartDto extends ProductDTO {
	private int Quantity;
	private int cartid;
	private String userid;

	public CartDto() {
		super();
	}

	
	public CartDto(int quantity, int cartid, String userid) {
		super();
		Quantity = quantity;
		this.cartid = cartid;
		this.userid = userid;
	}


	public int getQuantity() {
		return Quantity;
	}


	public void setQuantity(int quantity) {
		Quantity = quantity;
	}


	public int getCartid() {
		return cartid;
	}


	public void setCartid(int cartid) {
		this.cartid = cartid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		return "CartDto [Quantity=" + Quantity + ", cartid=" + cartid + ", userid=" + userid + "]";
	}

	
}

package com.Service;

import java.util.ArrayList;
import java.util.List;

import com.Dao.ProductDaO;
import com.user.ProductDTO;

public class ProductService {

	private ProductDaO dao;

	public ProductService() {
		dao = new ProductDaO();
	}
	
	public List<ProductDTO> getallProducts(){
		List<ProductDTO> allProductlist=dao.getallProducts();
		return allProductlist;
	}
}

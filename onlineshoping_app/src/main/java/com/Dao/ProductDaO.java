package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.DBConnection.DBCon;
import com.user.ProductDTO;

public class ProductDaO {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	private String allProducts = "Select * from product";

	public List<ProductDTO> getallProducts() {
		List<ProductDTO> allproducts = new ArrayList<>();
		try {
			con = DBCon.getconnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(allProducts);

			while (rs.next()) {

				ProductDTO dto = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5));
			
				allproducts.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allproducts;

	}
}

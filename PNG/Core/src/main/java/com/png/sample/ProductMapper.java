package com.png.sample;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class ProductMapper implements RowMapper<Product> {
	
	public Product mapRow (ResultSet rs, int rownum) throws SQLException {
		Product prod = new  Product();
		prod.setId(rs.getInt("Id"));
		prod.setName(rs.getString("Name"));
		prod.setColor(rs.getString("Color"));
		prod.setPrice(rs.getInt("Price"));
		return prod;
		
	}



}

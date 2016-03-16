package com.png.sample;

import org.springframework.jdbc.core.JdbcTemplate;

public class CatalogTools {
	
	private CoreDataSource coreDs;
	private JdbcTemplate jdbcTemplate;

	public CoreDataSource getCoreDs() {
		return coreDs;
	}

	public void setCoreDs(CoreDataSource coreDs) {
		this.coreDs = coreDs;
		this.jdbcTemplate = new JdbcTemplate(coreDs.getDataSource());
	}
	

	public void createProduct (String name, String color, int price) {
		String insertQuery = "Insert into Product (name, color, price) values (?,?,?)";
		jdbcTemplate.update(insertQuery, name, color, price);		
	}
	
	public Product getProduct (int id) {
		String selectQuery = "Select * from  Product where id = ?";
		return jdbcTemplate.queryForObject(selectQuery, new Object [] {id}, new ProductMapper());		
	}
	
}

package com.png.sample;

import org.springframework.data.annotation.Id;

public class ProductDetail {

	@Id
	private String id;
	private String name;
	private String description;
	private String color;
	private String price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	
	public String toString() {
		return "id: "+ getId() + " Name: " + getName() + " Description: "  + getDescription();
		
	}
}

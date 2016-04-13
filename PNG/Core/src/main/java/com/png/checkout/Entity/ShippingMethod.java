package com.png.checkout.Entity;

import org.springframework.data.annotation.Id;

public class ShippingMethod {

	@Id
	private String id;
	
	
	private String shippingMethodId;
	private String name;
	private String description;
	private double price;
	
	public String getShippingMethodId() {
		return shippingMethodId;
	}
	public void setShippingMethodId(String shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	
	
}

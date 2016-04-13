package com.png.checkout.Entity;

import org.springframework.data.annotation.Id;


public class ShippingGroup {
	
	@Id
	private String id;
	
	private String contactInfoId;
	private String ShippingMethodId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContactInfoId() {
		return contactInfoId;
	}
	public void setContactInfoId(String contactInfoId) {
		this.contactInfoId = contactInfoId;
	}
	public String getShippingMethodId() {
		return ShippingMethodId;
	}
	public void setShippingMethodId(String shippingMethodId) {
		ShippingMethodId = shippingMethodId;
	}
	
}

package com.png.checkout.vo;

import com.png.checkout.Entity.ShippingGroup;
import com.png.checkout.Entity.ShippingMethod;
import com.png.common.Entity.ContactInfo;

public class ShippingGroupResVO {
	
	
	private String shippingGroupId;
	private ContactInfo contactInfo;
	private ShippingMethod shippingMethod;
	
	
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getShippingGroupId() {
		return shippingGroupId;
	}
	public void setShippingGroupId(String shippingGroupId) {
		this.shippingGroupId = shippingGroupId;
	}

	
}
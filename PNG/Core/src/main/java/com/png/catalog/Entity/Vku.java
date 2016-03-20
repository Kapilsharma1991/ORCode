package com.png.catalog.Entity;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * @author Manish Arora
 *
 */
public class Vku {

	@Id
	private String id;
	
	@Indexed(unique = true)
	private String vkuId;
	
	public String getVkuId() {
		return vkuId;
	}
	public void setVkuId(String vkuId) {
		this.vkuId = vkuId;
	}
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	private String vendorId;
	private Calendar permitStartDate;
	private Calendar permitEndDate;
	private List<String> bookings;
	private VkuPricePoint vkuPricePoint;
	private String skuId; 
	
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public Calendar getPermitStartDate() {
		return permitStartDate;
	}
	public void setPermitStartDate(Calendar permitStartDate) {
		this.permitStartDate = permitStartDate;
	}
	public Calendar getPermitEndDate() {
		return permitEndDate;
	}
	public void setPermitEndDate(Calendar permitEndDate) {
		this.permitEndDate = permitEndDate;
	}
	public VkuPricePoint getVkuPricePoint() {
		return vkuPricePoint;
	}
	public void setVkuPricePoint(VkuPricePoint vkuPricePoint) {
		this.vkuPricePoint = vkuPricePoint;
	}
	public List<String> getBookings() {
		return bookings;
	}
	public void setBookings(List<String> bookings) {
		this.bookings = bookings;
	}
	public String getId() {
		return id;
	}
	
	
	
	
}

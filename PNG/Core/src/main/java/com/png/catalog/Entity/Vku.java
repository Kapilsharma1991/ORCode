package com.png.catalog.Entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * @author Manish Arora
 *
 */
public class Vku {

	@Id
	private String id;
	
	private String vendorId;
	private Date permitStartDate;
	private Date permitEndDate;
	private List<String> bookings;
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public Date getPermitStartDate() {
		return permitStartDate;
	}
	public void setPermitStartDate(Date permitStartDate) {
		this.permitStartDate = permitStartDate;
	}
	public Date getPermitEndDate() {
		return permitEndDate;
	}
	public void setPermitEndDate(Date permitEndDate) {
		this.permitEndDate = permitEndDate;
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

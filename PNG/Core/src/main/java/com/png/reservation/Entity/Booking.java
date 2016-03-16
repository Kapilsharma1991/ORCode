package com.png.reservation.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Booking {
	
	@Id
	private String id;
	
	private Date startDate;
	private Date endDate;
	private String vkuId;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getId() {
		return id;
	}
	public String getVkuId() {
		return vkuId;
	}
	public void setVkuId(String vkuId) {
		this.vkuId = vkuId;
	}
		

}

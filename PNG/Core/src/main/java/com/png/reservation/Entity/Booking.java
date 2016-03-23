package com.png.reservation.Entity;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.data.annotation.Id;

import com.png.base.BaseConstants;

/**
 * @author Manish Arora
 *
 */
public class Booking implements Comparable<Booking> {
	
	@Id
	private String id;
	
	private String startDate;
	private String endDate;
	private String vkuId;
	private int status;
	
	
	/**
	 * @param status
	 */
	public Booking(int status) {
		this.status = status;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String bookingStartDate) {
		this.startDate = bookingStartDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String bookingEndDate) {
		this.endDate = bookingEndDate;
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
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Booking o) {
		
		SimpleDateFormat df = new SimpleDateFormat(BaseConstants.DATE_FORMAT);
		Date start = null;
		int cmp = 0;
		try {
			start = df.parse(startDate);
			cmp =  start.compareTo(df.parse(o.getStartDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cmp;
		
	}
		

}

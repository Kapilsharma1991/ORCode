package com.png.reservation.Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.png.base.BaseConstants;
import com.png.order.commerce.ItemPriceInfo;
import com.png.serializer.JsonDateSerializer;

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
	private String skuId;
	private DateTime createdDate;
	
	/**
	 * @return the createdDate
	 */
	@JsonSerialize(using=JsonDateSerializer.class)
	public DateTime getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the skuId
	 */
	public String getSkuId() {
		return skuId;
	}
	/**
	 * @param skuId the skuId to set
	 */
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	private ItemPriceInfo itemPriceInfo;
	
	
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
	/**
	 * @return the itemPriceInfo
	 */
	public ItemPriceInfo getItemPriceInfo() {
		if (null == itemPriceInfo)
		return new ItemPriceInfo();
		else return itemPriceInfo;
	}
	/**
	 * @param itemPriceInfo the itemPriceInfo to set
	 */
	public void setItemPriceInfo(ItemPriceInfo itemPriceInfo) {
		this.itemPriceInfo = itemPriceInfo;
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

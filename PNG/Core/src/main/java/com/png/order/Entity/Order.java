/**
 * 
 */
package com.png.order.Entity;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

import com.png.order.pricing.OrderPriceInfo;

/**
 * @author Manish Arora
 *
 */
public class Order {
	
	@Id
	private String id;
	//private List<Booking> bookings;
	private List<String> bookings;
	private OrderPriceInfo orderPriceInfo;
	private String shippingGroupId;
	private DateTime createdDate;
	private DateTime lastModified;
	

	/**
	 * @param dateTime
	 */
	public Order(DateTime createdDate) {
		this.createdDate = createdDate;
	}



	public String getShippingGroupId() {
		return shippingGroupId;
	}



	public void setShippingGroupId(String shippingGroupId) {
		this.shippingGroupId = shippingGroupId;
	}



	/**
	 * @return the createdDate
	 */
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
	 * @return the lastModified
	 */
	public DateTime getLastModified() {
		return lastModified;
	}



	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(DateTime lastModified) {
		this.lastModified = lastModified;
	}



	/**
	 * @return the orderPriceInfo
	 */
	public OrderPriceInfo getOrderPriceInfo() {
		
		if (null == orderPriceInfo)
		{	
			return new OrderPriceInfo();
		} else return orderPriceInfo;
	}



	/**
	 * @param orderPriceInfo the orderPriceInfo to set
	 */
	public void setOrderPriceInfo(OrderPriceInfo orderPriceInfo) {
		this.orderPriceInfo = orderPriceInfo;
	}



	/**
	 * @return the bookings
	 *//*
	public List<Booking> getBookings() {
		
		if (null == bookings )
		{
			return new ArrayList<Booking>();
			
		} else 			
		return bookings;
	}



	*//**
	 * @param bookings the bookings to set
	 *//*
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}*/

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	
	/**
	 * @return the bookings
	 */
	public List<String> getBookings() {
		if (null == bookings )
		{
			return new ArrayList<String>();
			
		} else 			
		return bookings;
	}



	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<String> bookings) {
		this.bookings = bookings;
	}
	

}



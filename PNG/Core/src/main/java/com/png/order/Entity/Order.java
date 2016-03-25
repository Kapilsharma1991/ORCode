/**
 * 
 */
package com.png.order.Entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.png.order.pricing.OrderPriceInfo;
import com.png.reservation.Entity.Booking;

/**
 * @author Manish Arora
 *
 */
public class Order {
	
	@Id
	private String id;
	private List<Booking> bookings;
	private OrderPriceInfo orderPriceInfo;
	
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
	 */
	public List<Booking> getBookings() {
		
		if (null == bookings )
		{
			return new ArrayList<Booking>();
			
		} else 			
		return bookings;
	}



	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	

}



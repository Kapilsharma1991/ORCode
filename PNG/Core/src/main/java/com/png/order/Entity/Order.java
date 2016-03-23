/**
 * 
 */
package com.png.order.Entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.png.reservation.Entity.Booking;

/**
 * @author Manish Arora
 *
 */
public class Order {
	
	@Id
	private String id;
	
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



	List<Booking> bookings;



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	

}



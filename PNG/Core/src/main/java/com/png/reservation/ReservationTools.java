/**
 * 
 */
package com.png.reservation;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.png.reservation.Entity.Booking;

/**
 * @author Manish Arora
 *
 */
public class ReservationTools {

	MongoTemplate coreMongoTemplate;

	/**
	 * @return the coreMongoTemplate
	 */
	public MongoTemplate getCoreMongoTemplate() {
		return coreMongoTemplate;
	}

	/**
	 * @param coreMongoTemplate the coreMongoTemplate to set
	 */
	public void setCoreMongoTemplate(MongoTemplate coreMongoTemplate) {
		this.coreMongoTemplate = coreMongoTemplate;
	}

	/**
	 * @param booking
	 * @return
	 */
	public Booking createBooking(Booking booking) {
		
		getCoreMongoTemplate().insert(booking);
		return booking;
	}

	/**
	 * @param bookingId
	 * @return
	 */
	public Booking getBooking(String bookingId) {
		
		return getCoreMongoTemplate().findById(bookingId, Booking.class);
	}
	
	
	
}



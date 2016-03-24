/**
 * 
 */
package com.png.reservation;


import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.png.reservation.Entity.Booking;
import com.png.reservation.constant.ReservationConstants;

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
	 * @param coreMongoTemplate
	 *            the coreMongoTemplate to set
	 */
	public void setCoreMongoTemplate(MongoTemplate coreMongoTemplate) {
		this.coreMongoTemplate = coreMongoTemplate;
	}

	/**
	 * @param booking
	 * @return
	 */
	public Booking createBooking(Booking booking) {

		getCoreMongoTemplate().save(booking);
		return booking;
	}

	/**
	 * @param bookingId
	 * @return
	 */
	public Booking getActiveBooking(String bookingId) {

		Query query = new Query(Criteria
				.where(ReservationConstants.PROP_BOOKING_STATUS)
				.is(ReservationConstants.BOOKING_STATUS_ACTIVE)
				.andOperator(
						Criteria.where(ReservationConstants.PROP_BOOKING_ID)
								.is(bookingId)));
		List<Booking> list = getCoreMongoTemplate().find(query, Booking.class);
		if (null != list && list.size() > 0) {
			return getCoreMongoTemplate().find(query, Booking.class).get(0);
		} else return null;
		
	}

}

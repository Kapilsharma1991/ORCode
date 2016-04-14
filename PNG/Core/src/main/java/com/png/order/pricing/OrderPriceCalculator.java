/**
 * 
 */
package com.png.order.pricing;

import java.util.ArrayList;
import java.util.List;

import com.png.checkout.ShippingTools;
import com.png.checkout.Entity.ShippingMethod;
import com.png.order.Entity.Order;
import com.png.reservation.ReservationTools;
import com.png.reservation.Entity.Booking;

/**
 * @author Manish Arora
 *
 */
public class OrderPriceCalculator implements PriceCalculator {
	
	private ReservationTools reservationTools;
	private ShippingTools shippingTools;
	
	
	/**
	 * @return the reservationTools
	 */
	public ReservationTools getReservationTools() {
		return reservationTools;
	}
	/**
	 * @param reservationTools the reservationTools to set
	 */
	public void setReservationTools(ReservationTools reservationTools) {
		this.reservationTools = reservationTools;
	}
	

	/**
	 * @return the shippingTools
	 */
	public ShippingTools getShippingTools() {
		return shippingTools;
	}
	/**
	 * @param shippingTools the shippingTools to set
	 */
	public void setShippingTools(ShippingTools shippingTools) {
		this.shippingTools = shippingTools;
	}

	/**
	 * @param bookings
	 * @return
	 */
	public OrderPriceInfo repriceOrder(List<Booking> bookings) {
		OrderPriceInfo priceInfo = new OrderPriceInfo();

		double deposit = 0;
		double originalBookingPrice = 0;
		double finalBookingPrice = 0;
		
		for (Booking booking : bookings) {
			
			originalBookingPrice += booking.getItemPriceInfo().getOriginalPrice();
			finalBookingPrice += booking.getItemPriceInfo().getFinalPrice();
			deposit += booking.getItemPriceInfo().getDeposit();
		}
		
		double originalPrice = originalBookingPrice;
		double finalPrice = finalBookingPrice;
		
		priceInfo.setDeposit(deposit);
		priceInfo.setOriginalPrice(originalPrice);
		priceInfo.setFinalBookingPrice(finalBookingPrice);
		priceInfo.setFinalPrice(finalPrice);
		priceInfo.setOriginalBookingPrice(originalBookingPrice);
		
		return priceInfo;
	}

	/**
	 * @param order
	 */
	public void repriceOrder(Order order) {
		
		OrderPriceInfo priceInfo = new OrderPriceInfo();
		List<String> bookingIds = order.getBookings();
		List<Booking> bookings = new ArrayList<Booking>();
		for (String bookingId : bookingIds) {
			Booking booking = reservationTools.getBooking(bookingId);
			bookings.add(booking);
		}
		priceInfo = repriceOrder(bookings);

		String shippingGroupId = order.getShippingGroupId();
		if (shippingGroupId != null) {
			repriceOrder(shippingGroupId, priceInfo);
			
		}
		
		double savings = priceInfo.getOriginalPrice() - priceInfo.getFinalPrice();
		priceInfo.setSavings(savings);
		
		order.setOrderPriceInfo(priceInfo);
		
	}
	/**
	 * @param shippingGroupId
	 * @param priceInfo
	 */
	public void repriceOrder(String shippingGroupId, OrderPriceInfo priceInfo) {

		String shippingMethodId = getShippingTools().getShippingGroupById(
				shippingGroupId).getShippingMethodId();
		
		ShippingMethod shippingMethod = getShippingTools().getShippingMethodById(shippingMethodId);
		priceInfo.setShippingPrice(shippingMethod.getPrice());
		double originalPrice = priceInfo.getOriginalBookingPrice() + shippingMethod.getPrice();
		double finalPrice = priceInfo.getFinalBookingPrice() + shippingMethod.getPrice();
		priceInfo.setFinalPrice(finalPrice);
		priceInfo.setOriginalPrice(originalPrice);
		
	}

}



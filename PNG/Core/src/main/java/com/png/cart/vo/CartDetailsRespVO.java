/**
 * 
 */
package com.png.cart.vo;

import java.util.List;

import com.png.cart.SkuSummary;
import com.png.order.pricing.OrderPriceInfo;
import com.png.reservation.Entity.Booking;

/**
 * @author Manish Arora
 *
 */
public class CartDetailsRespVO {

	private List<Booking> bookings;
	private List<SkuSummary> skuSummaryList;
	private OrderPriceInfo orderPriceInfo;
	/**
	 * @return the bookings
	 */
	public List<Booking> getBookings() {
		return bookings;
	}
	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	/**
	 * @return the skuSummaryList
	 */
	public List<SkuSummary> getSkuSummaryList() {
		return skuSummaryList;
	}
	/**
	 * @param skuSummaryList the skuSummaryList to set
	 */
	public void setSkuSummaryList(List<SkuSummary> skuSummaryList) {
		this.skuSummaryList = skuSummaryList;
	}
	/**
	 * @return the orderPriceInfo
	 */
	public OrderPriceInfo getOrderPriceInfo() {
		return orderPriceInfo;
	}
	/**
	 * @param orderPriceInfo the orderPriceInfo to set
	 */
	public void setOrderPriceInfo(OrderPriceInfo orderPriceInfo) {
		this.orderPriceInfo = orderPriceInfo;
	}
}



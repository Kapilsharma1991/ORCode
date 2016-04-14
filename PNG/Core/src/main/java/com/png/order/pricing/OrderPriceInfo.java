/**
 * 
 */
package com.png.order.pricing;

import com.png.base.BasePriceInfo;

/**
 * @author Manish Arora
 *
 */
public class OrderPriceInfo extends BasePriceInfo {
	
	private double originalBookingPrice;
	private double finalBookingPrice;
	private double shippingPrice;

	
	/**
	 * @return the shippingPrice
	 */
	public double getShippingPrice() {
		return shippingPrice;
	}
	/**
	 * @param shippingPrice the shippingPrice to set
	 */
	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	/**
	 * @return the originalBookingPrice
	 */
	public double getOriginalBookingPrice() {
		return originalBookingPrice;
	}
	/**
	 * @param originalBookingPrice the originalBookingPrice to set
	 */
	public void setOriginalBookingPrice(double originalBookingPrice) {
		this.originalBookingPrice = originalBookingPrice;
	}
	/**
	 * @return the finalBookingPrice
	 */
	public double getFinalBookingPrice() {
		return finalBookingPrice;
	}
	/**
	 * @param finalBookingPrice the finalBookingPrice to set
	 */
	public void setFinalBookingPrice(double finalBookingPrice) {
		this.finalBookingPrice = finalBookingPrice;
	}
	
}



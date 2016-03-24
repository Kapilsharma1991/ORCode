/**
 * 
 */
package com.png.order.pricing;

import com.png.order.commerce.ItemPriceInfo;
import com.png.reservation.Entity.Booking;

/**
 * @author Manish Arora
 *
 */
public class PricingEngine {
	
	private ItemPriceCalculator itemPriceCalculator;
	private OrderPriceCalculator orderPriceCalculator;
	/**
	 * @return the itemPriceCalculator
	 */
	public ItemPriceCalculator getItemPriceCalculator() {
		return itemPriceCalculator;
	}
	/**
	 * @param itemPriceCalculator the itemPriceCalculator to set
	 */
	public void setItemPriceCalculator(ItemPriceCalculator itemPriceCalculator) {
		this.itemPriceCalculator = itemPriceCalculator;
	}
	/**
	 * @return the orderPriceCalculator
	 */
	public OrderPriceCalculator getOrderPriceCalculator() {
		return orderPriceCalculator;
	}
	/**
	 * @param orderPriceCalculator the orderPriceCalculator to set
	 */
	public void setOrderPriceCalculator(OrderPriceCalculator orderPriceCalculator) {
		this.orderPriceCalculator = orderPriceCalculator;
	}
	/**
	 * @param booking
	 * @param skuId
	 * @return 
	 */
	public ItemPriceInfo repriceBooking(String startDate, String endDate, String skuId) {
		return getItemPriceCalculator().repriceBooking(startDate, endDate, skuId);
		
	}
	
	

}



/**
 * 
 */
package com.png.order;

import java.util.List;

import com.png.order.Entity.Order;
import com.png.order.pricing.OrderPriceInfo;
import com.png.order.pricing.PricingEngine;
import com.png.reservation.Entity.Booking;
import com.png.session.SessionManager;

/**
 * @author Manish Arora
 *
 */
public class OrderManager {
	
	private SessionManager sessionManager;
	private OrderTools orderTools;
	private PricingEngine pricingEngine;
	/**
	 * @return the sessionManager
	 */
	public SessionManager getSessionManager() {
		return sessionManager;
	}
	/**
	 * @param sessionManager the sessionManager to set
	 */
	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}
	/**
	 * @return the orderTools
	 */
	public OrderTools getOrderTools() {
		return orderTools;
	}
	/**
	 * @param orderTools the orderTools to set
	 */
	public void setOrderTools(OrderTools orderTools) {
		this.orderTools = orderTools;
	}
	
	/**
	 * @return the pricingEngine
	 */
	public PricingEngine getPricingEngine() {
		return pricingEngine;
	}
	/**
	 * @param pricingEngine the pricingEngine to set
	 */
	public void setPricingEngine(PricingEngine pricingEngine) {
		this.pricingEngine = pricingEngine;
	}
	public Order getOrder() {
		return getSessionManager().getOrder();
	}
	
	public void setOrder(Order order) {
		getSessionManager().setOrder(order);
	}
	
	public String updateOrder (Order order) {
		setOrder(getOrderTools().updateOrder(order));
		return order.getId();
		
	}
	
	/**
	 * @param order
	 */
	public void repriceOrder(Order order) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @param bookings
	 * @return
	 */
	public OrderPriceInfo repriceOrder(List<Booking> bookings) {
		
		OrderPriceInfo priceInfo = new OrderPriceInfo();
		getPricingEngine().repriceOrder(bookings,priceInfo);
		return priceInfo;
	}
	/**
	 * @param orderId
	 * @return 
	 */
	public Order getOrder(String orderId) {
		
		return orderTools.getOrder(orderId);
		
	}
	

}



/**
 * 
 */
package com.png.order;

import com.png.order.Entity.Order;
import com.png.reservation.Entity.Booking;
import com.png.session.SessionManager;

/**
 * @author Manish Arora
 *
 */
public class OrderManager {
	
	private SessionManager sessionManager;
	private OrderTools orderTools;
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
	 * @param booking
	 * @param skuId
	 */
	public void repriceBooking(Booking booking, String skuId) {
		// TODO Auto-generated method stub
		
	}
	

}



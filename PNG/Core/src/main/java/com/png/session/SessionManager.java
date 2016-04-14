/**
 * 
 */
package com.png.session;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.png.order.Entity.Order;

/**
 * @author Manish Arora
 *
 */
public class SessionManager {
	
	private Order order;

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) { 
		this.order = order;
	}

	 public void init(){
	      
		setOrder(new Order(new DateTime(DateTimeZone.forID("Asia/Kolkata")))); 
		 
	   }
	
}



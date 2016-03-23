/**
 * 
 */
package com.png.order;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.png.order.Entity.Order;

/**
 * @author Manish Arora
 *
 */
public class OrderTools {
	
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
	 * @param order
	 * @return
	 */
	public Order updateOrder(Order order) {
		
		coreMongoTemplate.insert(order);
		return order;
	}
	

}



/**
 * 
 */
package com.png.cart;

import org.springframework.data.mongodb.core.MongoTemplate;

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
	

}



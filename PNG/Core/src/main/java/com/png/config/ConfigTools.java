/**
 * 
 */
package com.png.config;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 * @author Manish Arora
 *
 */
public class ConfigTools {
	
	private MongoTemplate coreMongoTemplate;

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
	 * @param propertyName
	 */
	public String getProperty(String propertyName) {
		
		Query query = new Query(Criteria.where("PropName").is(propertyName));
		return getCoreMongoTemplate().findOne(query, CommonConfig.class ).getPropValue();
			
	}

}



/**
 * 
 */
package com.png.catalog;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.png.catalog.Entity.Product;

/**
 * @author Manish Arora
 *
 */
public class CatalogTools {
	
	private MongoTemplate catMongoTemplate;

	public MongoTemplate getCatMongoTemplate() {
		return catMongoTemplate;
	}

	public void setCatMongoTemplate(MongoTemplate catMongoTemplate) {
		this.catMongoTemplate = catMongoTemplate;
	}
	
	
	public Product getProduct(String prodId) {
		return catMongoTemplate.findById(prodId, Product.class);
	}

}



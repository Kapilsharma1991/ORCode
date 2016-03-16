package com.png.sample;

import org.springframework.data.mongodb.core.MongoTemplate;

public class CoreMongoTools {

	MongoTemplate coreMongoTemplate;

	public MongoTemplate getCoreMongoTemplate() {
		return coreMongoTemplate;
	}

	public void setCoreMongoTemplate(MongoTemplate coreMongoTemplate) {
		this.coreMongoTemplate = coreMongoTemplate;
	}
	
	public String createProduct(ProductDetail prd) {
		coreMongoTemplate.insert(prd);
		return prd.getId();
	}
	
	public ProductDetail getProduct (String id) {
		return coreMongoTemplate.findById(id, ProductDetail.class);
	}
}

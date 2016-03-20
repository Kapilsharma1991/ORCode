/**
 * 
 */
package com.png.catalog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.png.catalog.Entity.Product;
import com.png.catalog.Entity.Sku;

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
		
		Query query = new Query(Criteria.where("productId").is(prodId));	
		return catMongoTemplate.find(query, Product.class).get(0);
		
	}

	/**
	 * @param object
	 */
	public void createCatalogItem(Object object) {
		
		catMongoTemplate.insert(object);
		
	}

	/**
	 * @param skus
	 * @return
	 */
	public List<Sku> getSkus(List<String> skus) {
	
		List<Sku> skuList = new ArrayList<Sku>();
		
		for(String skuId: skus) {
			
			Sku sku = getSku(skuId);
			skuList.add(sku);
			
		}
		
		return skuList;
	}

	/**
	 * @param sku
	 * @return
	 */
	private Sku getSku(String skuId) {
		
		Query query = new Query(Criteria.where("skuId").is(skuId));	
		return catMongoTemplate.find(query, Sku.class).get(0);
	}

}



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
import com.png.catalog.Entity.Vku;

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
	public Sku getSku(String skuId) {
		
		Query query = new Query(Criteria.where("skuId").is(skuId));	
		return catMongoTemplate.find(query, Sku.class).get(0);
	}

	/**
	 * @param availableVku
	 * @param id
	 */
	public void updateVkuWithBookingId(String availableVku, String bookingId) {
		
		Vku vku = getVku(availableVku);
		vku.setBookings(vku.getBookings().add(bookingId) ? vku.getBookings():vku.getBookings());
		updateVku(vku);
	}

	/**
	 * @param vku
	 */
	public void updateVku(Vku vku) {
		catMongoTemplate.save(vku);
		
	}

	/**
	 * @param availableVku
	 * @return
	 */
	public Vku getVku(String vkuId) {
		
		Query query = new Query(Criteria.where("vkuId").is(vkuId));	
		return catMongoTemplate.find(query, Vku.class).get(0);
	}

}



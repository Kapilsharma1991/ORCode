/**
 * 
 */
package com.png.catalog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.png.catalog.Entity.Catalog;
import com.png.catalog.Entity.Category;
import com.png.catalog.Entity.Product;
import com.png.catalog.Entity.ProductImage;
import com.png.catalog.Entity.Sku;
import com.png.catalog.Entity.SkuImage;
import com.png.catalog.Entity.SkuPricePoint;
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
		
		catMongoTemplate.save(object);
		
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
		List<String> bookings = new ArrayList<String>();
		bookings.add(bookingId);
		vku.setBookings(bookings);
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

	/**
	 * @param orCatalogId
	 * @return
	 */
	public Catalog getCatalog(String catalogId) {
		
		Query query = new Query(Criteria.where("catalogId").is(catalogId));	
		return catMongoTemplate.find(query, Catalog.class).get(0);
		
	}

	/**
	 * @return
	 */
	public Category getCategory(String catId) {
		
		Query query = new Query(Criteria.where("categoryId").is(catId));
		return catMongoTemplate.find(query, Category.class).size() > 0 ? catMongoTemplate.find(query, Category.class).get(0) : null;
	}

/*	*//**
	 * @param skuImages
	 * @return
	 *//*
	public SkuImage getSkuImage(List<String> skuImages) {
		
		SkuImage skuImage = new SkuImage();
		if (skuImages != null && skuImages.size() > 0) {
			skuImage = catMongoTemplate.findById(skuImages.get(0), SkuImage.class);
		}
		
		return skuImage;
	}*/

	/**
	 * @param imageId
	 * @return
	 */
	public ProductImage getProductImage(String imageId) {
		
		return catMongoTemplate.findById(imageId, ProductImage.class);
	}

	/**
	 * @param imageId
	 * @return
	 */
	public SkuImage getSkuImage(String imageId) {
		return catMongoTemplate.findById(imageId, SkuImage.class);
	}

	/**
	 * @param skuPricePointId
	 * @return
	 */
	public SkuPricePoint getSkuPricePoint(String skuPricePointId) {
		return catMongoTemplate.findById(skuPricePointId, SkuPricePoint.class);
	}

}



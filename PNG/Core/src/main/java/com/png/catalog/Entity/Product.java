package com.png.catalog.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Product {

	@Id
	private String id;
	
	@Indexed(unique = true)
	private String productId;
	
	private String name;
	private String description;
	private List<ProductImage> productImage;
	private String parentCategoryId;
	private List<String> skus;
	private float aggregateRating;
	private int numOfReviews;
	private List<String> recommendedProducts;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public List<String> getSkus() {
		return skus;
	}
	public void setSkus(List<String> skus) {
		this.skus = skus;
	}
	public String getId() {
		return id;
	}
	public List<ProductImage> getProductImage() {
		return productImage;
	}
	public void setProductImage(List<ProductImage> productImage) {
		this.productImage = productImage;
	}
	public List<String> getRecommendedProducts() {
		return recommendedProducts;
	}
	public void setRecommendedProducts(List<String> recommendedProducts) {
		this.recommendedProducts = recommendedProducts;
	}
	public float getAggregateRating() {
		return aggregateRating;
	}
	public void setAggregateRating(float aggregateRating) {
		this.aggregateRating = aggregateRating;
	}
	public int getNumOfReviews() {
		return numOfReviews;
	}
	public void setNumOfReviews(int numOfReviews) {
		this.numOfReviews = numOfReviews;
	}
}

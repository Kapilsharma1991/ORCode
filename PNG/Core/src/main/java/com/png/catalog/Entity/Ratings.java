package com.png.catalog.Entity;

/**
 * @author Manish Arora
 *
 */
import org.springframework.data.annotation.Id;

public class Ratings {
	
	@Id
	private String id;
	
	private String productId;
	private int rating;
	private String review;
	private String userId;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	

}

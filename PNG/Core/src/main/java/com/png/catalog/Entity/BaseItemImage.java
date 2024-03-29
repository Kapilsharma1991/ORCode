package com.png.catalog.Entity;

import org.springframework.data.annotation.Id;


/**
 * @author Manish Arora
 *
 */
public class BaseItemImage {
	
	@Id
	private String id;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	private String thumbnailImage;
	private String smallImage;
	private String medIMage;
	private String largeImage;
	

	public String getThumbnailImage() {
		return thumbnailImage;
	}
	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}
	public String getSmallImage() {
		return smallImage;
	}
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}
	public String getMedIMage() {
		return medIMage;
	}
	public void setMedIMage(String medIMage) {
		this.medIMage = medIMage;
	}
	public String getLargeImage() {
		return largeImage;
	}
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}
	
}

package com.png.catalog.Entity;

import org.springframework.data.annotation.Id;

/**
 * @author Manish Arora
 *
 */
public class Banner {

	@Id
	private String id;
	
	private String name;
	private String bannerImage;
	private String TabText;
	private String destCategoryId;
	private String destProductId;
	private String destCategoryUrl;
	private String destProductUrl;
	private int priority;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public String getTabText() {
		return TabText;
	}

	public void setTabText(String tabText) {
		TabText = tabText;
	}

	public String getDestCategoryId() {
		return destCategoryId;
	}

	public void setDestCategoryId(String destCategoryId) {
		this.destCategoryId = destCategoryId;
	}

	public String getDestProductId() {
		return destProductId;
	}

	public void setDestProductId(String destProductId) {
		this.destProductId = destProductId;
	}

	public String getDestCategoryUrl() {
		return destCategoryUrl;
	}

	public void setDestCategoryUrl(String destCategoryUrl) {
		this.destCategoryUrl = destCategoryUrl;
	}

	public String getDestProductUrl() {
		return destProductUrl;
	}

	public void setDestProductUrl(String destProductUrl) {
		this.destProductUrl = destProductUrl;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getId() {
		return id;
	}


}

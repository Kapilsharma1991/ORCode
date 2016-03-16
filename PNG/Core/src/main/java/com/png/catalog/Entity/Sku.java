package com.png.catalog.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Sku {

	@Id
	private String id;
	
	@Indexed(unique = true)
	private String skuId;
	
	private String name;
	private String description;
	private List<SkuImage> skuImage;
	private String parentProductId;
	private SkuPricePoint skuPricePoint;
	private List<String> vkus;
	
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
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
	public List<SkuImage> getSkuImage() {
		return skuImage;
	}
	public void setSkuImage(List<SkuImage> skuImage) {
		this.skuImage = skuImage;
	}
	public String getParentProductId() {
		return parentProductId;
	}
	public void setParentProductId(String parentProductId) {
		this.parentProductId = parentProductId;
	}
	public SkuPricePoint getSkuPricePoint() {
		return skuPricePoint;
	}
	public void setSkuPricePoint(SkuPricePoint skuPricePoint) {
		this.skuPricePoint = skuPricePoint;
	}
	public List<String> getVkus() {
		return vkus;
	}
	public void setVkus(List<String> vkus) {
		this.vkus = vkus;
	}
	public String getId() {
		return id;
	}
}

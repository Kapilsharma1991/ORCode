package com.png.catalog.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Category {

	@Id
	private String id;
	
	@Indexed(unique = true)
	private String categoryId;
	
	private String name;
	private String thumbnailImage;
	private List<Banner> banners;
	private String parentCategoryId;
	private boolean isRoot;
	private List<String> childCategories;
	private List<String> childProducts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public List<Banner> getBanners() {
		return banners;
	}

	public void setBanners(List<Banner> banners) {
		this.banners = banners;
	}

	public String getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	public List<String> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(List<String> childCategories) {
		this.childCategories = childCategories;
	}

	public List<String> getChildProducts() {
		return childProducts;
	}

	public void setChildProducts(List<String> childProducts) {
		this.childProducts = childProducts;
	}

	public String getId() {
		return id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}

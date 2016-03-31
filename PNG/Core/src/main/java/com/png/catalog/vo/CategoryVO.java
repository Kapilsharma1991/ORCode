/**
 * 
 */
package com.png.catalog.vo;

import java.util.List;

/**
 * @author Manish Arora
 *
 */
public class CategoryVO {

	private List<CategoryVO> categories;
	private String categoryId;
	private String name;
	private boolean isRoot;
	private boolean hasChildCat;
	private boolean hasChildProducts;

	
	/**
	 * @return the hasChildProducts
	 */
	public boolean isHasChildProducts() {
		return hasChildProducts;
	}

	/**
	 * @param hasChildProducts the hasChildProducts to set
	 */
	public void setHasChildProducts(boolean hasChildProducts) {
		this.hasChildProducts = hasChildProducts;
	}

	/**
	 * @return the isRoot
	 */
	public boolean isRoot() {
		return isRoot;
	}

	/**
	 * @param isRoot the isRoot to set
	 */
	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	/**
	 * @return the hasChildCat
	 */
	public boolean isHasChildCat() {
		return hasChildCat;
	}

	/**
	 * @param hasChildCat the hasChildCat to set
	 */
	public void setHasChildCat(boolean hasChildCat) {
		this.hasChildCat = hasChildCat;
	}


	/**
	 * @return the categories
	 */
	public List<CategoryVO> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<CategoryVO> categories) {
		this.categories = categories;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}

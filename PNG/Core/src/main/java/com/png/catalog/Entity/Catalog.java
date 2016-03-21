package com.png.catalog.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * @author Manish Arora
 *
 */
public class Catalog {
	
	@Id
	private String id;
	
	private String catalogId;
	/**
	 * @return the catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}
	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	private String name;
	private String description;
	private List<String> rootCategories;
	
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
	public List<String> getRootCategories() {
		return rootCategories;
	}
	public void setRootCategories(List<String> rootCategories) {
		this.rootCategories = rootCategories;
	}
	public String getId() {
		return id;
	}

}

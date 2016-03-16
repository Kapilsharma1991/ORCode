package com.png.catalog.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Catalog {
	
	@Id
	private String id;
	
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

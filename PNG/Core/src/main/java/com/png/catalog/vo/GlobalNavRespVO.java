/**
 * 
 */
package com.png.catalog.vo;

import java.util.List;

/**
 * @author Manish Arora
 *
 */
public class GlobalNavRespVO {
	
	private List<CategoryVO> navCategories;

	/**
	 * @return the navCategories
	 */
	public List<CategoryVO> getNavCategories() {
		return navCategories;
	}

	/**
	 * @param navCategories the navCategories to set
	 */
	public void setNavCategories(List<CategoryVO> navCategories) {
		this.navCategories = navCategories;
	}

}



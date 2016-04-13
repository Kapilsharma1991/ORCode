/**
 * 
 */
package com.png.config;

import org.springframework.data.annotation.Id;

/**
 * @author Manish Arora
 *
 */
public class CommonConfig {

	@Id
	private String id;
	
	/**
	 * @return the propName
	 */
	public String getPropName() {
		return propName;
	}
	/**
	 * @param propName the propName to set
	 */
	public void setPropName(String propName) {
		this.propName = propName;
	}
	/**
	 * @return the propValue
	 */
	public String getPropValue() {
		return propValue;
	}
	/**
	 * @param propValue the propValue to set
	 */
	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	private String propName;
	private String propValue;
	
}



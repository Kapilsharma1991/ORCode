/**
 * 
 */
package com.png.config;

/**
 * @author Manish Arora
 *
 */
public class PngConfigManager {
	
	private ConfigTools configTools;

	/**
	 * @return the configTools
	 */
	public ConfigTools getConfigTools() {
		return configTools;
	}

	/**
	 * @param configTools the configTools to set
	 */
	public void setConfigTools(ConfigTools configTools) {
		this.configTools = configTools;
	}

	/**
	 * @param pngIv
	 */
	public String getProperty(String propertyName) {
		return getConfigTools().getProperty(propertyName);
		
	}

}



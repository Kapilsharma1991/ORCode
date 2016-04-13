/**
 * 
 */
package com.png.security;

import com.png.base.BaseConstants;
import com.png.config.PngConfigManager;
import com.png.framework.security.AesUtil;

/**
 * @author Manish Arora
 *
 */
public class PngSecurityManager {
	
	private AesUtil aesUtil;
	private PngConfigManager configManager; 

	/**
	 * @return the configManager
	 */
	public PngConfigManager getConfigManager() {
		return configManager;
	}

	/**
	 * @param configManager the configManager to set
	 */
	public void setConfigManager(PngConfigManager configManager) {
		this.configManager = configManager;
	}

	/**
	 * @return the aesUtil
	 */
	public AesUtil getAesUtil() {
		return aesUtil;
	}

	/**
	 * @param aesUtil the aesUtil to set
	 */
	public void setAesUtil(AesUtil aesUtil) {
		this.aesUtil = aesUtil;
	}

	/**
	 * @param password
	 * @return
	 */
	public String decrypt(String CIPHER_TEXT) {
		
		String SALT = getSalt(getConfigManager().getProperty(BaseConstants.PNG_STATIC_SALT));
		return decrypt(CIPHER_TEXT, SALT);

	}
	
	
	/**
	 * @param password
	 * @return
	 */
	public String encrypt(String PLAIN_TEXT) {
		
		String SALT = getSalt(getConfigManager().getProperty(BaseConstants.PNG_STATIC_SALT));
		return encrypt(PLAIN_TEXT, SALT);
	}
	
	
	public String decrypt(String CIPHER_TEXT, String SALT) {
		
		String decrypt = getAesUtil().decrypt(SALT, getIV(), getPassPhrase(),
				CIPHER_TEXT);
		return decrypt;
	}

	

	public String encrypt(String PLAIN_TEXT, String SALT) {
		
		String encrypt = getAesUtil().encrypt(SALT, getIV(), getPassPhrase(),
				PLAIN_TEXT);
		// System.out.println(encrypt);
		return encrypt;
	}

	
	/**
	 * @return
	 */
	private String getPassPhrase() {
		
		return getConfigManager().getProperty(BaseConstants.PNG_PASSPHRASE);
	}

	/**
	 * @return
	 */
	private String getIV() {
		
		return getConfigManager().getProperty(BaseConstants.PNG_IV);

	}
	
	private String getSalt(String staticSalt) {
		StringBuffer half1SALT = null, half2SALT = null;
		if (1 == staticSalt.length() % 2) {
			half1SALT = new StringBuffer(staticSalt.substring(1,
					(staticSalt.length() + 1) / 2));
			half2SALT = new StringBuffer(staticSalt.substring(
					(staticSalt.length() + 1) / 2,
					staticSalt.length()));
		} else {
			half1SALT = new StringBuffer(staticSalt.substring(1,
					staticSalt.length() / 2));
			half2SALT = new StringBuffer(staticSalt.substring(
					(staticSalt.length() + 1) / 2,
					staticSalt.length()));
		}
		while (half1SALT.length() < 32) {
			half1SALT.append("0");
		}
		while (half2SALT.length() < 32) {
			half2SALT.append("0");
		}
		String salt = (half1SALT.reverse().append(half2SALT.reverse())).toString();
		return salt;
	}
}



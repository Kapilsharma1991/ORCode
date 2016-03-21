/**
 * 
 */
package com.png.cart.vo;

import com.png.base.BaseRequestVO;

/**
 * @author Manish Arora
 *
 */
public class CartModifierReqVO extends BaseRequestVO {

	private String productId;
	private String skuId;
	private String vkuId;
	private String action;
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the skuId
	 */
	public String getSkuId() {
		return skuId;
	}
	/**
	 * @param skuId the skuId to set
	 */
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	/**
	 * @return the vkuId
	 */
	public String getVkuId() {
		return vkuId;
	}
	/**
	 * @param vkuId the vkuId to set
	 */
	public void setVkuId(String vkuId) {
		this.vkuId = vkuId;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
}



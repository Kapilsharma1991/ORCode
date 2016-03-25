/**
 * 
 */
package com.png.cart.vo;

import com.png.base.BaseRequestVO;

/**
 * @author Manish Arora
 *
 */
public class CartDetailsReqVO extends BaseRequestVO {

	private String orderId;

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}



/**
 * 
 */
package com.png.cart.vo;

/**
 * @author Manish Arora
 *
 */
public class CartModifierRespVO {
	
	private String orderId;
	private String userFlowMsg;

	/**
	 * @return the userFlowMsg
	 */
	public String getUserFlowMsg() {
		return userFlowMsg;
	}

	/**
	 * @param userFlowMsg the userFlowMsg to set
	 */
	public void setUserFlowMsg(String userFlowMsg) {
		this.userFlowMsg = userFlowMsg;
	}

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



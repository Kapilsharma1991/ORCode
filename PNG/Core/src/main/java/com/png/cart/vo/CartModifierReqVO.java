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

	private String action;
	private String bookingStartDate;
	private String bookingEndDate;
	private int qty;
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
	/**
	 * @return the bookingStartDate
	 */
	public String getBookingStartDate() {
		return bookingStartDate;
	}
	/**
	 * @param bookingStartDate the bookingStartDate to set
	 */
	public void setBookingStartDate(String bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}
	/**
	 * @return the bookingEndDate
	 */
	public String getBookingEndDate() {
		return bookingEndDate;
	}
	/**
	 * @param bookingEndDate the bookingEndDate to set
	 */
	public void setBookingEndDate(String bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}
	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}




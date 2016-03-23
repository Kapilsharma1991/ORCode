/**
 * 
 */
package com.png.order.commerce;

import org.bson.types.ObjectId;


/**
 * @author Manish Arora
 *
 */
public class CommerceItem {
	
	public CommerceItem() {
		setId(new ObjectId().toString());
	}
	
	private String id;
	private String bookingId;
	private ItemPriceInfo itemPriceInfo;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	private void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the bookingId
	 */
	public String getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * @return the itemPriceInfo
	 */
	public ItemPriceInfo getItemPriceInfo() {
		return itemPriceInfo;
	}
	/**
	 * @param itemPriceInfo the itemPriceInfo to set
	 */
	public void setItemPriceInfo(ItemPriceInfo itemPriceInfo) {
		this.itemPriceInfo = itemPriceInfo;
	}
	
	

}



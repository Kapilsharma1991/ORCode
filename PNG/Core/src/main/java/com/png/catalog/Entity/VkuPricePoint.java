/**
 * 
 */
package com.png.catalog.Entity;

import org.springframework.data.annotation.Id;

/**
 * @author Manish Arora
 *
 */
public class VkuPricePoint {
	
	public double getFullRetailPrice() {
		return fullRetailPrice;
	}
	public void setFullRetailPrice(double fullRetailPrice) {
		this.fullRetailPrice = fullRetailPrice;
	}
	public boolean isOfferBuyOption() {
		return offerBuyOption;
	}
	public void setOfferBuyOption(boolean offerBuyOption) {
		this.offerBuyOption = offerBuyOption;
	}
	public double getOfferBuyPrice() {
		return offerBuyPrice;
	}
	public void setOfferBuyPrice(double offerBuyPrice) {
		this.offerBuyPrice = offerBuyPrice;
	}

	private double fullRetailPrice;
	private boolean offerBuyOption;
	private double offerBuyPrice;

}



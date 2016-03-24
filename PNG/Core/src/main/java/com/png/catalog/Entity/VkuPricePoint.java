/**
 * 
 */
package com.png.catalog.Entity;


/**
 * @author Manish Arora
 *
 */
public class VkuPricePoint {
	
	private double fullRetailPrice;
	private boolean offerBuyOption;
	private double offerBuyPrice;
	private double deposit;
	
	
	/**
	 * @return the deposit
	 */
	public double getDeposit() {
		return deposit;
	}
	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
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

}



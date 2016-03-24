package com.png.catalog.Entity;

/**
 * @author Manish Arora
 *
 */

public class SkuPricePoint {
	
	private double dailyPrice;
	private double weeklyPrice;
	private double monthlyPrice;
	private double quaterlyPrice;
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
	public double getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	public double getWeeklyPrice() {
		return weeklyPrice;
	}
	public void setWeeklyPrice(double weeklyPrice) {
		this.weeklyPrice = weeklyPrice;
	}
	public double getMonthlyPrice() {
		return monthlyPrice;
	}
	public void setMonthlyPrice(double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}
	public double getQuaterlyPrice() {
		return quaterlyPrice;
	}
	public void setQuaterlyPrice(double quaterlyPrice) {
		this.quaterlyPrice = quaterlyPrice;
	}
	

}

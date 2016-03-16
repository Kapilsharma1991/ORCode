package com.png.catalog.Entity;

import org.springframework.data.annotation.Id;

public class SkuPricePoint {
	
	@Id
	private String Id;
	
	private float dailyPrice;
	private float weeklyPrice;
	private float monthlyPrice;
	private float quaterlyPrice;
	
	public float getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	public float getWeeklyPrice() {
		return weeklyPrice;
	}
	public void setWeeklyPrice(float weeklyPrice) {
		this.weeklyPrice = weeklyPrice;
	}
	public float getMonthlyPrice() {
		return monthlyPrice;
	}
	public void setMonthlyPrice(float monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}
	public float getQuaterlyPrice() {
		return quaterlyPrice;
	}
	public void setQuaterlyPrice(float quaterlyPrice) {
		this.quaterlyPrice = quaterlyPrice;
	}
	public String getId() {
		return Id;
	}
	
	

}

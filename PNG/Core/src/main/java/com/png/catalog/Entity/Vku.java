package com.png.catalog.Entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * @author Manish Arora
 *
 */
public class Vku {

	@Id
	private String id;

	@Indexed(unique = true)
	private String vkuId;

	public String getVkuId() {
		return vkuId;
	}

	public void setVkuId(String vkuId) {
		this.vkuId = vkuId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	private String vendorId;

	private String permitStartDate;
	private String permitEndDate;

	private List<String> bookings;
	private VkuPricePoint vkuPricePoint;
	private String skuId;

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the permitStartDate
	 */
	public String getPermitStartDate() {
		return permitStartDate;
	}

	/**
	 * @param permitStartDate
	 *            the permitStartDate to set
	 */
	public void setPermitStartDate(String permitStartDate) {
		this.permitStartDate = permitStartDate;
	}

	/**
	 * @return the permitEndDate
	 */
	public String getPermitEndDate() {
		return permitEndDate;
	}

	/**
	 * @param permitEndDate
	 *            the permitEndDate to set
	 */
	public void setPermitEndDate(String permitEndDate) {
		this.permitEndDate = permitEndDate;
	}

	public VkuPricePoint getVkuPricePoint() {
		return vkuPricePoint;
	}

	public void setVkuPricePoint(VkuPricePoint vkuPricePoint) {
		this.vkuPricePoint = vkuPricePoint;
	}

	public List<String> getBookings() {
		if (null != bookings) {
			return bookings;
		} else {
			return new ArrayList<String>();
		}
	}

	public void setBookings(List<String> bookings) {
		this.bookings = bookings;
	}

	public String getId() {
		return id;
	}

}

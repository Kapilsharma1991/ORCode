/**
 * 
 */
package com.png.order.pricing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.png.base.BaseConstants;
import com.png.catalog.CatalogTools;
import com.png.catalog.Entity.Sku;
import com.png.order.commerce.ItemPriceInfo;
import com.png.reservation.Entity.Booking;

/**
 * @author Manish Arora
 *
 */
public class ItemPriceCalculator implements PriceCalculator {

	private CatalogTools catalogTools;

	/**
	 * @return the catalogTools
	 */
	public CatalogTools getCatalogTools() {
		return catalogTools;
	}

	/**
	 * @param catalogTools
	 *            the catalogTools to set
	 */
	public void setCatalogTools(CatalogTools catalogTools) {
		this.catalogTools = catalogTools;
	}

	/**
	 * @param booking
	 * @param skuId
	 * @return 
	 */
	public ItemPriceInfo repriceBooking(String startDate, String endDate, String skuId) {

		int bookingDays = 0;
		SimpleDateFormat df = new SimpleDateFormat(BaseConstants.DATE_FORMAT);
		try {
			bookingDays = getDateDiff(df.parse(endDate),
					df.parse(startDate), TimeUnit.DAYS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Sku sku = getCatalogTools().getSku(skuId);
		double dailyPrice = sku.getSkuPricePoint().getDailyPrice();
		double weeklyPrice = sku.getSkuPricePoint().getWeeklyPrice();
		double monthlyPrice = sku.getSkuPricePoint().getMonthlyPrice();
		double quaterlyPrice = sku.getSkuPricePoint().getQuaterlyPrice();
		double itemPrice = getPrice(bookingDays, dailyPrice, weeklyPrice,
				monthlyPrice, quaterlyPrice);
		ItemPriceInfo priceInfo = new ItemPriceInfo();
		priceInfo.setOriginalPrice(itemPrice);
		priceInfo.setDeposit(
				catalogTools.getSku(skuId).getSkuPricePoint()
						.getDeposit());
		return priceInfo;

	}

	/**
	 * @param bookingDays
	 * @param dailyPrice
	 * @param weeklyPrice
	 * @param monthlyPrice
	 * @param quaterlyPrice
	 * @return
	 */
	private double getPrice(int bookingDays, double dailyPrice,
			double weeklyPrice, double monthlyPrice, double quaterlyPrice) {

		int numOfQuaters = bookingDays / 90;
		int numOfMonths = numOfQuaters > 0 ? ((bookingDays % 90) / 30)
				: (bookingDays / 30);
		int numOfWeeks = numOfMonths > 0 ? (((bookingDays % 90) % 30) / 7)
				: (bookingDays / 7);
		int numOfDays = numOfWeeks > 0 ? (((bookingDays % 90) % 30) % 7)
				: (bookingDays);

		return (numOfQuaters * quaterlyPrice) + (numOfMonths * monthlyPrice)
				+ (numOfWeeks * weeklyPrice) + (numOfDays * dailyPrice);
	}

	public int getDateDiff(Date end, Date start, TimeUnit timeUnit) {
		long diffInMillies = end.getTime() - start.getTime();
		return (int) timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

}

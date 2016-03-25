/**
 * 
 */
package com.png.reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.png.base.BaseConstants;
import com.png.catalog.CatalogTools;
import com.png.catalog.Entity.Sku;
import com.png.catalog.Entity.Vku;
import com.png.order.pricing.PricingEngine;
import com.png.reservation.Entity.Booking;
import com.png.reservation.constant.ReservationConstants;

/**
 * @author Manish Arora
 *
 */
public class ReservationEngine {

	private ReservationTools reservationTools;
	private CatalogTools catalogTools;
	private PricingEngine pricingEngine;

	/**
	 * @return the pricingEngine
	 */
	public PricingEngine getPricingEngine() {
		return pricingEngine;
	}

	/**
	 * @param pricingEngine the pricingEngine to set
	 */
	public void setPricingEngine(PricingEngine pricingEngine) {
		this.pricingEngine = pricingEngine;
	}

	/**
	 * @return the reservationTools
	 */
	public ReservationTools getReservationTools() {
		return reservationTools;
	}

	/**
	 * @param reservationTools
	 *            the reservationTools to set
	 */
	public void setReservationTools(ReservationTools reservationTools) {
		this.reservationTools = reservationTools;
	}

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
	 * @param skuId
	 * @param qty
	 * @param bookingStartDate
	 * @param bookingEndDate
	 * @return
	 */
	public List<String> checkAvailability(String skuId, int qty,
			String bookingStartDate, String bookingEndDate) {

		List<String> vkus = new ArrayList<String>();
		int vkuCounter = 0;
		Sku sku = catalogTools.getSku(skuId);
		for (String vkuId : sku.getVkus()) {

			if (checkVkuAvailability(getCatalogTools().getVku(vkuId),
					bookingStartDate, bookingEndDate)) {
				vkuCounter++;
				vkus.add(vkuId);
				if (vkuCounter == qty) {
					break;
				}
			}

		}

		return vkus;
	}

	/**
	 * @param vku
	 * @param bookingEndDate
	 * @param bookingStartDate
	 * @return
	 */
	private boolean checkVkuAvailability(Vku vku, String bookingStartDate,
			String bookingEndDate) {

		SimpleDateFormat df = new SimpleDateFormat(BaseConstants.DATE_FORMAT);
		boolean isVkuAvaillable = false;

		try {

			Date bStartDate = df.parse(bookingStartDate);
			Date bEndDate = df.parse(bookingEndDate);
			Date permitStartDate = df.parse(vku.getPermitStartDate());
			Date permitEndDate = df.parse(vku.getPermitEndDate());

			if (permitStartDate.before(bStartDate)
					&& permitEndDate.after(bEndDate)) {

				List<Booking> bookingList = new ArrayList<Booking>();

				for (String bookingId : vku.getBookings()) {
					Booking booking = reservationTools
							.getActiveBooking(bookingId);
					if (null != booking) {
						bookingList.add(booking);
					}
				}

				int size = bookingList.size();
				if (bookingList.size() == 0) {
					return true;
				}
				Collections.sort(bookingList);

				Date userBookingEndDate = df.parse(bookingEndDate);
				Date userBookingStartDate = df.parse(bookingStartDate);
				if ((userBookingEndDate.compareTo(df.parse(bookingList.get(0)
						.getStartDate())) <= 0)
						|| (userBookingStartDate.compareTo(df.parse(bookingList
								.get(size - 1).getEndDate())) >= 0)) {
					isVkuAvaillable = true;
					return isVkuAvaillable;
				}

				for (int i = 1; i < bookingList.size(); i++) {

					Date ped = df.parse(bookingList.get(i - 1).getEndDate());
					Date nsd = df.parse(bookingList.get(i).getStartDate());

					if ((userBookingStartDate.compareTo(ped) >= 0)
							&& (userBookingEndDate.compareTo(nsd) <= 0)) {
						isVkuAvaillable = true;
						break;
					}

				}

			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isVkuAvaillable;
	}

	/**
	 * @param skuId
	 * @param bookingStartDate
	 * @param bookingEndDate
	 * @param string 
	 * @return
	 */
	public Booking createBooking(String vkuId, String skuId, String bookingStartDate,
			String bookingEndDate) {

		Booking booking = new Booking(ReservationConstants.BOOKING_STATUS_OPEN);
		booking.setVkuId(vkuId);
		booking.setSkuId(skuId);
		booking.setStartDate(bookingStartDate);
		booking.setEndDate(bookingEndDate);
		booking.setItemPriceInfo(getPricingEngine().repriceBooking(bookingStartDate,bookingEndDate , skuId));
		return getReservationTools().createBooking(booking);
	}

}

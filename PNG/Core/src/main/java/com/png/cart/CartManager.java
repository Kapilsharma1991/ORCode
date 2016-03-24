/**
 * 
 */
package com.png.cart;

import java.util.List;

import com.png.base.BaseManager;
import com.png.base.ErrorMap;
import com.png.cart.constant.CartErrorMessageConstants;
import com.png.cart.vo.CartModifierReqVO;
import com.png.cart.vo.CartModifierRespVO;
import com.png.catalog.CatalogTools;
import com.png.order.OrderManager;
import com.png.order.Entity.Order;
import com.png.reservation.ReservationEngine;
import com.png.reservation.Entity.Booking;

/**
 * @author Manish Arora
 *
 */
public class CartManager extends BaseManager {

	private ReservationEngine reservationEngine;

	private OrderManager orderManager;

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
	 * @return the reservationEngine
	 */
	public ReservationEngine getReservationEngine() {
		return reservationEngine;
	}

	/**
	 * @param reservationEngine
	 *            the reservationEngine to set
	 */
	public void setReservationEngine(ReservationEngine reservationEngine) {
		this.reservationEngine = reservationEngine;
	}

	/**
	 * @return the orderManager
	 */
	public OrderManager getOrderManager() {
		return orderManager;
	}

	/**
	 * @param orderManager
	 *            the orderManager to set
	 */
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	/**
	 * @param productId
	 * @param skuId
	 * @param vkuId
	 * @return
	 */
	public CartModifierRespVO addItemToCart(String productId, String skuId,
			String vkuId) {

		CartModifierRespVO resp = new CartModifierRespVO();
		//resp.setTest("test add to cart wiring - method implementation is pending");
		return resp;
	}

	/**
	 * @param addToCartReqVO
	 * @param emap 
	 * @return
	 */
	public CartModifierRespVO addItemToCart(CartModifierReqVO addToCartReqVO, ErrorMap emap) {

				CartModifierRespVO resp = new CartModifierRespVO();
		List<String> availableVkus = reservationEngine.checkAvailability(
				addToCartReqVO.getSkuId(), addToCartReqVO.getQty(),
				addToCartReqVO.getBookingStartDate(),
				addToCartReqVO.getBookingEndDate());

		if (availableVkus.size() != 0 
				&& availableVkus.size() == addToCartReqVO.getQty()) {
			
			Order order = orderManager.getOrder();
			List<Booking> bookings = order.getBookings();
			
			for (String availableVku : availableVkus) {
				Booking booking = reservationEngine.createBooking(availableVku, addToCartReqVO.getSkuId(),
						addToCartReqVO.getBookingStartDate(),
						addToCartReqVO.getBookingEndDate());

				catalogTools.updateVkuWithBookingId(availableVku,
						booking.getId());
				bookings.add(booking);
			}
			
			order.setBookings(bookings);
			orderManager.repriceOrder(order);
			resp.setOrderId(orderManager.updateOrder(order));
			

		} else { 
			
			if (availableVkus.size() == 0) {
				emap.setErrorMessage((CartErrorMessageConstants.ERROR_MSG_PRODUCT_UNAVAILABLE));
				emap.setErrorCode(CartErrorMessageConstants.FLOW_CODE_ONE);
			} else if (availableVkus.size() != addToCartReqVO.getQty()) {
				
				StringBuilder sb = new StringBuilder(CartErrorMessageConstants.ERROR_MSG_LESS_QTY_UNAVAILABLE);
				sb.append(availableVkus.size());
				emap.setErrorMessage(sb.toString());
				emap.setErrorCode(CartErrorMessageConstants.FLOW_CODE_TWO);
			}

		}

		return resp;
	}

}

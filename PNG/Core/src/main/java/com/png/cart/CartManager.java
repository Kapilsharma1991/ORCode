/**
 * 
 */
package com.png.cart;

import java.util.ArrayList;
import java.util.List;

import com.png.base.BaseManager;
import com.png.base.ErrorMap;
import com.png.cart.constant.CartErrorMessageConstants;
import com.png.cart.vo.CartDetailsReqVO;
import com.png.cart.vo.CartDetailsRespVO;
import com.png.cart.vo.CartModifierReqVO;
import com.png.cart.vo.CartModifierRespVO;
import com.png.cart.vo.SkuSummaryVO;
import com.png.catalog.CatalogTools;
import com.png.catalog.Entity.Sku;
import com.png.catalog.Entity.SkuImage;
import com.png.order.OrderManager;
import com.png.order.Entity.Order;
import com.png.reservation.ReservationEngine;
import com.png.reservation.ReservationTools;
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
			List<String> bookingIds = order.getBookings();
			
			for (String availableVku : availableVkus) {
				String bookingId = reservationEngine.createBooking(availableVku, addToCartReqVO.getSkuId(),
						addToCartReqVO.getBookingStartDate(),
						addToCartReqVO.getBookingEndDate());

				catalogTools.updateVkuWithBookingId(availableVku,
						bookingId);
				bookingIds.add(bookingId);
				
			}
		
			order.setBookings(bookingIds);
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

	/**
	 * @param cartReqVO
	 * @param emap
	 * @return
	 */
	public CartDetailsRespVO getCartDetails(CartDetailsReqVO reqVO,
			ErrorMap emap) {
		
		CartDetailsRespVO resp = new CartDetailsRespVO();
		Order order = null;
		
		if (reqVO.getOrderId() !=null) {
			order = orderManager.getOrder(reqVO.getOrderId());
		} else {
			order = orderManager.getOrder();
		}
		
		List<SkuSummaryVO> skuSummaryList = new ArrayList<SkuSummaryVO>();
		List<Booking> bookings = new ArrayList<Booking>();
		
		for (String bookingId : order.getBookings())
		{
			
			ReservationTools tools = getReservationEngine().getReservationTools();
			Booking booking = tools.getBooking(bookingId);
			bookings.add(booking);
			SkuSummaryVO summ = new SkuSummaryVO();
			summ.setSkuId(booking.getSkuId());
			Sku sku = getCatalogTools().getSku(booking.getSkuId());
			SkuImage image = new SkuImage();
			image = getCatalogTools().getSkuImage(sku.getSkuImageIds().get(0));
			summ.setName(sku.getName());
			summ.setMedImg(image.getMedIMage());
			summ.setSmallImg(image.getSmallImage());
			
		/*	SkuImage skuImage = getCatalogTools().getSkuImage(sku.getSkuImageIds());
			summ.setMedImg(skuImage.getMedIMage());
			summ.setSmallImg(skuImage.getSmallImage());*/
			skuSummaryList.add(summ);	
			
		}
		
		resp.setBookings(bookings);
		resp.setSkuSummaryList(skuSummaryList);
		resp.setOrderPriceInfo(order.getOrderPriceInfo());
		
		return resp;
	}

}

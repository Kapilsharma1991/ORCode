/**
 * 
 */
package com.png.cart;

import com.png.base.BaseManager;
import com.png.cart.vo.CartModifierRespVO;

/**
 * @author Manish Arora
 *
 */
public class CartManager extends BaseManager {
	
	
	
	OrderTools orderTools;

	/**
	 * @return the orderTools
	 */
	public OrderTools getOrderTools() {
		return orderTools;
	}

	/**
	 * @param orderTools the orderTools to set
	 */
	public void setOrderTools(OrderTools orderTools) {
		this.orderTools = orderTools;
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
		resp.setTest("test add to cart wiring - method implementation is pending");
		return resp;
	}

}



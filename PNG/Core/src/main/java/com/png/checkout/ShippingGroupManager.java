/**
 * 
 */
package com.png.checkout;

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
import com.png.checkout.Entity.ShippingGroup;
import com.png.checkout.Entity.ShippingMethod;
import com.png.checkout.vo.ShippingGroupReqVO;
import com.png.common.Entity.ContactInfo;
import com.png.order.OrderManager;
import com.png.order.Entity.Order;
import com.png.reservation.ReservationEngine;
import com.png.reservation.Entity.Booking;

/**
 * @author Manish Arora
 *
 */
public class ShippingGroupManager extends BaseManager {
	
	private ShippingTools shippingTools;

	public ShippingTools getShippingTools() {
		return shippingTools;
	}

	public void setShippingTools(ShippingTools shippingTools) {
		this.shippingTools = shippingTools;
	}
	
	//shipping Info
	
	public String createShippingContactInfo(ShippingGroupReqVO object) {
		//populate contact info to persist
		ContactInfo contactInfo =  new ContactInfo();
		contactInfo.setFirstName(object.getFirstName());
		contactInfo.setLastName(object.getLastName());
		contactInfo.setAddressLine1(object.getAddress1());
		contactInfo.setAddressLine2(object.getAddress2());
		contactInfo.setCity(object.getCity());
		contactInfo.setState(object.getState());
		contactInfo.setPhoneNumber(object.getPhoneNumber());
		contactInfo.setPinCode(object.getPincode());
	
		return shippingTools.createContactInfoItem(contactInfo);
		
	}
	
	public ContactInfo getContactInfoItemById(String id) {
		
			return shippingTools.getContactInfoItemById(id);
		}
	
	public ShippingMethod getShippingMethodByShippingMethodId(String shippingMethodId) {
	
		return shippingTools.getShippingMethodByShippingMethodId(shippingMethodId);
	}
	
	public String createShippingGroup(ShippingGroup shippingGrp){
		
		 return shippingTools.createShippingGroup(shippingGrp);
	}

}

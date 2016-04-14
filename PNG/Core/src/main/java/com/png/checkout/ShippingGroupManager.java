/**
 * 
 */
package com.png.checkout;

import com.png.base.BaseManager;
import com.png.checkout.Entity.ShippingGroup;
import com.png.checkout.Entity.ShippingMethod;
import com.png.checkout.vo.ShippingGroupReqVO;
import com.png.common.Entity.ContactInfo;

/**
 * @author Ricky Sahota
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

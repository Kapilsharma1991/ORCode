/**
 * 
 */
package com.png.checkout;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.png.base.BaseConstants;
import com.png.base.BaseRequestVO;
import com.png.base.BaseValidator;
import com.png.base.ErrorMap;
import com.png.cart.constant.CartConstants;
import com.png.cart.vo.CartModifierReqVO;
import com.png.catalog.constant.CatalogErrorMsgConstants;
import com.png.checkout.constant.CheckoutConstants;
import com.png.checkout.vo.ShippingGroupReqVO;
import com.png.common.validator.AddressValidator;
import com.png.reservation.constant.ReservationErrorConstant;

/**
 * @author Manish Arora
 *
 */
public class ShippingGroupValidator extends BaseValidator {
	
	private AddressValidator addressValidator;

	public AddressValidator getAddressValidator() {
		return addressValidator;
	}

	public void setAddressValidator(AddressValidator addressValidator) {
		this.addressValidator = addressValidator;
	}

	public ErrorMap validate(BaseRequestVO reqVO, int actionInd) {

		ErrorMap emap = super.validate(reqVO);

		switch (actionInd) {

		case CheckoutConstants.ACTION_ADD_NEW_SHIPPING_GROUP:

			ShippingGroupReqVO vo = (ShippingGroupReqVO) reqVO;

			if(!addressValidator.isValidFirstName(vo.getFirstName(),emap)){
				return emap;
			}else if (!addressValidator.isValidAddress(vo.getAddress1(), emap)) {
				return emap;
			} else if (!addressValidator.isValidCity(vo.getCity(), emap)) {
				return emap;
			}else if (!addressValidator.isValidState(vo.getState(), emap)) {
				return emap;
			}else if (!addressValidator.isValidPinCode(vo.getPincode(), emap)) {
				return emap;
			}else if (!addressValidator.isValidPhoneNumber(vo.getPhoneNumber(), emap)) {
				return emap;
			}else if (!addressValidator.isValidPhoneNumber(vo.getPhoneNumber(), emap)) {
				return emap;
			}

			
		}

		return emap;
	}

}

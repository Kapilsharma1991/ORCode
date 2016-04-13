/**
 * 
 */
package com.png.common.validator;

import org.springframework.util.StringUtils;

import com.png.base.BaseConstants;
import com.png.base.ErrorMap;
import com.png.checkout.constant.CheckoutErrorMsgConstants;
import com.png.myacc.constant.UserProfileErrorMsgConstants;

/**
 * @author Manish Arora
 *
 */
public class AddressValidator {

	/**
	 * @param emailId
	 * @param emap
	 * @return
	 */
	public boolean isValidEmail(String emailId, ErrorMap emap) {

		if (StringUtils.isEmpty(emailId)) {
			emap.setErrorMessage(UserProfileErrorMsgConstants.MISSING_EMAIL_ID);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_ONE);
			return false;
		}

		return true;

	}

	/**
	 * @param password
	 * @param emap
	 * @return
	 */
	public boolean isValidPassword(String password, ErrorMap emap) {

		if (StringUtils.isEmpty(password)) {
			emap.setErrorMessage(UserProfileErrorMsgConstants.MISSING_PASSWORD_ID);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
			return false;
		}

		return true;
	}
	
	/**
	 * @param password
	 * @param emap
	 * @return
	 */
	public boolean isValidFirstName(String firstName, ErrorMap emap) {

		if (StringUtils.isEmpty(firstName)) {
			emap.setErrorMessage(UserProfileErrorMsgConstants.MISSING_FIRST_NAME);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
			return false;
		}

		return true;
	}
	/**
	 * @param password
	 * @param emap
	 * @return
	 */
	public boolean isValidAddress(String address, ErrorMap emap) {

		if (StringUtils.isEmpty(address)) {
			emap.setErrorMessage(UserProfileErrorMsgConstants.MISSING_ADDRESS_FIELD);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
			return false;
		}

		return true;
	}
	/**
	 * @param password
	 * @param emap
	 * @return
	 */
	public boolean isValidCity(String city, ErrorMap emap) {

		if (StringUtils.isEmpty(city)) {
			emap.setErrorMessage(UserProfileErrorMsgConstants.MISSING_CITY_NAME);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
			return false;
		}

		return true;
	}
	
	/**
	 * @param password
	 * @param emap
	 * @return
	 */
	public boolean isValidState(String state, ErrorMap emap) {

		if (StringUtils.isEmpty(state)) {
			emap.setErrorMessage(UserProfileErrorMsgConstants.MISSING_STATE_NAME);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
			return false;
		}

		return true;
	}
	
	/**
	 * @param password
	 * @param emap
	 * @return
	 */
	public boolean isValidPinCode(String pinCode, ErrorMap emap) {

		if (StringUtils.isEmpty(pinCode)) {
			emap.setErrorMessage(UserProfileErrorMsgConstants.MISSING_PIN_CODE);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
			return false;
		}

		return true;
	}
	/**
	 * @param password
	 * @param emap
	 * @return
	 */
	public boolean isValidPhoneNumber(String phoneNumber, ErrorMap emap) {

		if (StringUtils.isEmpty(phoneNumber)) {
			emap.setErrorMessage(UserProfileErrorMsgConstants.MISSING_PHONE_NUMBER);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
			return false;
		}
		if (!StringUtils.isEmpty(phoneNumber) && phoneNumber.length() > 10) {
			emap.setErrorMessage(UserProfileErrorMsgConstants.MISSING_PHONE_NUMBER);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
			return false;
		}

		return true;
	}/**
	 * @param password
	 * @param emap
	 * @return
	 */
	public boolean isValidshippingMethod(String shippingMethod, ErrorMap emap) {

		if (StringUtils.isEmpty(shippingMethod)) {
			emap.setErrorMessage(CheckoutErrorMsgConstants.MISSING_SHIPPING_METHOD);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
			return false;
		}

		return true;
	}
	

}

/**
 * 
 */
package com.png.common.validator;

import com.png.base.BaseConstants;
import com.png.base.ErrorMap;
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

		if (null == emailId) {
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

		if (null == password) {
			emap.setErrorMessage(UserProfileErrorMsgConstants.MISSING_PASSWORD_ID);
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
			return false;
		}

		return true;
	}

}

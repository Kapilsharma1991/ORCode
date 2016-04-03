/**
 * 
 */
package com.png.myacc;

import com.png.base.BaseRequestVO;
import com.png.base.BaseValidator;
import com.png.base.ErrorMap;
import com.png.common.validator.AddressValidator;
import com.png.myacc.constant.UserProfileConstants;
import com.png.myacc.vo.UserProfileReqVO;

/**
 * @author Manish Arora
 *
 */
public class UserProfileValidator extends BaseValidator {

	private AddressValidator addressValidator;

	/**
	 * @return the addressValidator
	 */
	public AddressValidator getAddressValidator() {
		return addressValidator;
	}

	/**
	 * @param addressValidator
	 *            the addressValidator to set
	 */
	public void setAddressValidator(AddressValidator addressValidator) {
		this.addressValidator = addressValidator;
	}

	/**
	 * @param actionInd
	 * @param userProfileReqVO
	 * @return
	 */

	public ErrorMap validate(BaseRequestVO reqVO, int actionInd) {

		ErrorMap emap = super.validate(reqVO);

		switch (actionInd) {

		case UserProfileConstants.ACTION_CREATE_USER:

			UserProfileReqVO vo = (UserProfileReqVO) reqVO;
			if (!addressValidator.isValidEmail(vo.getEmailId(), emap)) {
				return emap;
			} else if (!addressValidator
					.isValidPassword(vo.getPassword(), emap)) {
				return emap;
			}
		}
		return emap;
	}

}

/**
 * 
 */
package com.png.cart;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.png.base.BaseConstants;
import com.png.base.BaseRequestVO;
import com.png.base.BaseValidator;
import com.png.base.ErrorMap;
import com.png.cart.constant.CartConstants;
import com.png.cart.vo.CartModifierReqVO;
import com.png.catalog.constant.CatalogErrorMsgConstants;
import com.png.reservation.constant.ReservationErrorConstant;

/**
 * @author Manish Arora
 *
 */
public class CartValidator extends BaseValidator {

	public ErrorMap validate(BaseRequestVO reqVO, int actionInd) {

		ErrorMap emap = super.validate(reqVO);

		switch (actionInd) {

		case CartConstants.ACTION_ADD_TO_CART:

			CartModifierReqVO vo = (CartModifierReqVO) reqVO;

			SimpleDateFormat df = new SimpleDateFormat(
					BaseConstants.DATE_FORMAT);

			if (vo.getSkuId() == null) {
				emap.setErrorMessage(CatalogErrorMsgConstants.MISSING_SKU_ID);
				emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_ONE);
			} else
				try {
					if (df.parse(vo.getBookingEndDate()).compareTo(
							df.parse(vo.getBookingStartDate())) <= 0) {
						emap.setErrorMessage(ReservationErrorConstant.INVALID_END_DATE);
						emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_TWO);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		}

		return emap;
	}

}

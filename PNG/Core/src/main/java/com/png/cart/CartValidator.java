/**
 * 
 */
package com.png.cart;

import com.png.base.BaseConstants;
import com.png.base.BaseRequestVO;
import com.png.base.BaseValidator;
import com.png.base.ErrorMap;
import com.png.cart.vo.CartModifierReqVO;
import com.png.catalog.constant.CatalogErrorMsgConstants;

/**
 * @author Manish Arora
 *
 */
public class CartValidator extends BaseValidator {
	
	/* (non-Javadoc)
	 * @see com.png.base.BaseValidator#validate(com.png.base.BaseRequestVO)
	 */
	@Override
	public ErrorMap validate(BaseRequestVO reqVO) {
		
		ErrorMap emap = super.validate(reqVO);
		
		CartModifierReqVO vo = (CartModifierReqVO) reqVO;
		
	 if (vo.getSkuId() == null) {
			emap.setErrorMessage(CatalogErrorMsgConstants.MISSING_SKU_ID);
			emap.setErrorCode(BaseConstants.ERROR_CODE_ONE);
		} else if (vo.getProductId() == null) {
			emap.setErrorMessage(CatalogErrorMsgConstants.MISSING_PRODUCT_ID);
			emap.setErrorCode(BaseConstants.ERROR_CODE_ONE);
		}
		return emap;
	}

}



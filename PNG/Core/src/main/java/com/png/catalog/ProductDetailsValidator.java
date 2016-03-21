package com.png.catalog;

import com.png.base.BaseConstants;
import com.png.base.BaseRequestVO;
import com.png.base.BaseValidator;
import com.png.base.ErrorMap;
import com.png.catalog.constant.CatalogErrorMsgConstants;
import com.png.catalog.vo.PDPReqVO;

/**
 * @author Manish Arora
 *
 */
public class ProductDetailsValidator extends BaseValidator {
	
	/* (non-Javadoc)
	 * @see com.png.base.BaseValidator#validate(com.png.base.BaseRequestVO)
	 */
	@Override
	public ErrorMap validate(BaseRequestVO reqVO) {
		
		ErrorMap emap = super.validate(reqVO);
		
		PDPReqVO vo = (PDPReqVO) reqVO;
		if (vo.getProductId() == null) {
			emap.setErrorMessage(CatalogErrorMsgConstants.MISSING_PRODUCT_ID);
			emap.setErrorCode(BaseConstants.ERROR_CODE_ONE);
		}
		return emap;
	}


	

}

package com.png.catalog;

import java.util.List;

import com.png.base.BaseConstants;
import com.png.base.BaseManager;
import com.png.base.ErrorMap;
import com.png.catalog.Entity.Product;
import com.png.catalog.Entity.Sku;
import com.png.catalog.constant.CatalogErrorMsgConstants;
import com.png.catalog.vo.PDPRespVO;

/**
 * @author Manish Arora
 *
 */
public class ProductDetailsManager extends BaseManager {
	
	
	private CatalogTools catalogTools;

	public CatalogTools getCatalogTools() {
		return catalogTools;
	}

	public void setCatalogTools(CatalogTools catalogTools) {
		this.catalogTools = catalogTools;
	}

	/**
	 * @param emap 
	 * @param string 
	 * @return
	 */
	public PDPRespVO getProductDetails(String prodId, ErrorMap emap) {
		
		PDPRespVO pdpResVO = new PDPRespVO();
		Product prod = catalogTools.getProduct(prodId);
		if (null == prod) {
			emap.setErrorCode(BaseConstants.ERROR_CODE_TWENTY_ONE);
			emap.setErrorMessage(CatalogErrorMsgConstants.NO_PRODUCT_FOUND);
			return pdpResVO;
		}
		List<Sku> skus = catalogTools.getSkus(prod.getSkus());
        pdpResVO.setProduct(prod);
        pdpResVO.setSkus(skus);
		return pdpResVO;
	}


	/**
	 * @param object
	 */
	public void createCatalogItem(Object object) {
		
		catalogTools.createCatalogItem(object);
		
	}

}

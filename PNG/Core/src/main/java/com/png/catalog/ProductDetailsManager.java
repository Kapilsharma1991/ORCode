package com.png.catalog;

import com.png.base.BaseManager;
import com.png.base.Output;
import com.png.catalog.Entity.Product;

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
	 * @param string 
	 * @return
	 */
	public PDPRespVO getProductDetails(String prodId) {
		
		PDPRespVO pdpResVO = new PDPRespVO();
		Product p = catalogTools.getProduct(prodId);
		Output output = new Output(p);
		pdpResVO.setOutput(output);
		return pdpResVO;
	}

}

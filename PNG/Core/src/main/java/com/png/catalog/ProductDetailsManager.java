package com.png.catalog;

import java.util.ArrayList;
import java.util.List;

import com.png.base.BaseConstants;
import com.png.base.BaseManager;
import com.png.base.ErrorMap;
import com.png.catalog.Entity.BaseItemImage;
import com.png.catalog.Entity.Product;
import com.png.catalog.Entity.ProductImage;
import com.png.catalog.Entity.Sku;
import com.png.catalog.Entity.SkuImage;
import com.png.catalog.Entity.SkuPricePoint;
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
		ProductImage pImage = catalogTools.getProductImage(prod.getImageId());
		prod.setProductImage(pImage);
		List<Sku> skus = catalogTools.getSkus(prod.getSkus());

		if (skus != null && skus.size() > 0) {

			for (Sku sku : skus) {
				List<String> imageIds = sku.getSkuImageIds();

				if (imageIds != null && imageIds.size() > 0) {
					List<SkuImage> skuImageList = new ArrayList<SkuImage>();
					for (String imageId : imageIds) {
						SkuImage skuImage = catalogTools.getSkuImage(imageId);
						skuImageList.add(skuImage);
					}
					sku.setSkuImage(skuImageList);
				}

				SkuPricePoint skuPricePoint = new SkuPricePoint();
				skuPricePoint = catalogTools.getSkuPricePoint(sku
						.getSkuPricePointId());
				sku.setSkuPricePoint(skuPricePoint);

			}
		}

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

	/**
	 * @param si1
	 * @param b
	 * @return
	 */
	public String createImage(BaseItemImage object) {

		catalogTools.createCatalogItem(object);
		return object.getId();
	}

	/**
	 * @param pp
	 * @return
	 */
	public String createPricePoint(SkuPricePoint object) {
		catalogTools.createCatalogItem(object);
		return object.getId();
	}

}

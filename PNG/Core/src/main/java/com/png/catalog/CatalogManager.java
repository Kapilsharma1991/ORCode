/**
 * 
 */
package com.png.catalog;

import java.util.ArrayList;
import java.util.List;

import com.png.catalog.Entity.Category;
import com.png.catalog.constant.CatalogConstants;
import com.png.catalog.vo.CategoryVO;
import com.png.catalog.vo.GlobalNavRespVO;

/**
 * @author Manish Arora
 *
 */
public class CatalogManager {
	
	private CatalogTools catalogTools;

	/**
	 * @return the catalogTools
	 */
	public CatalogTools getCatalogTools() {
		return catalogTools;
	}

	/**
	 * @param catalogTools the catalogTools to set
	 */
	public void setCatalogTools(CatalogTools catalogTools) {
		this.catalogTools = catalogTools;
	}

	/**
	 * @return
	 */
	public GlobalNavRespVO getGlobalNav() {
		
		GlobalNavRespVO respVO = new GlobalNavRespVO();
		List<String> categoryIds = catalogTools.getCatalog(CatalogConstants.OR_CATALOG_ID).getRootCategories();
		
		List<CategoryVO> catList = new ArrayList<CategoryVO>();
		
		for (String catId : categoryIds) {
			
			Category root = catalogTools.getCategory(catId);
			if (null != root && null != root.getChildCategories()) {
			CategoryVO rootVO = translateCategoryToVO(root);
			
			List<CategoryVO> subCatList = new ArrayList<CategoryVO>();
			
			for (String  subCatId : root.getChildCategories()) {
				
				Category subCat = catalogTools.getCategory(subCatId);
				if (null != subCat) {
				CategoryVO subVO = translateCategoryToVO(subCat);
				
				List<CategoryVO> chldCatList = new ArrayList<CategoryVO>();
				
				if (subCat.getChildCategories() != null && subCat.getChildCategories().size() >0) {
				
				for (String  chldCatId : subCat.getChildCategories()) {
					
					Category chldCat = catalogTools.getCategory(chldCatId);
					if (chldCat !=null) {
					CategoryVO chldVO = translateCategoryToVO(chldCat);
					chldCatList.add(chldVO); 
					}
				}
				
				}
				
				subVO.setCategories(chldCatList);
				subCatList.add(subVO);		
				}
			}
			
			rootVO.setCategories(subCatList);
			catList.add(rootVO);
			}
		}
		
		respVO.setNavCategories(catList);
		return respVO;
	}

	/**
	 * @param root
	 * @return
	 */
	private CategoryVO translateCategoryToVO(Category cat) {
		CategoryVO categoryVO = new  CategoryVO();
		categoryVO.setCategoryId(cat.getCategoryId());
		categoryVO.setName(cat.getName());
		categoryVO.setRoot(cat.isRoot());
		if (null != cat.getChildCategories() && cat.getChildCategories().size() > 0) {
			categoryVO.setHasChildCat(true);
		}
		 
		if (null != cat.getChildProducts() && cat.getChildProducts().size() > 0) {
			categoryVO.setHasChildProducts(true);
		}
		return categoryVO;
	}
	

}



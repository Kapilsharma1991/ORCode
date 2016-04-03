package com.png.catalog;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.png.base.BaseConstants;
import com.png.base.BaseController;
import com.png.base.ErrorMap;
import com.png.base.Output;
import com.png.base.ResponseVO;
import com.png.catalog.Entity.Banner;
import com.png.catalog.Entity.Catalog;
import com.png.catalog.Entity.Category;
import com.png.catalog.Entity.Product;
import com.png.catalog.Entity.ProductImage;
import com.png.catalog.Entity.Sku;
import com.png.catalog.Entity.SkuImage;
import com.png.catalog.Entity.SkuPricePoint;
import com.png.catalog.Entity.Vku;
import com.png.catalog.Entity.VkuPricePoint;
import com.png.catalog.vo.GlobalNavRespVO;
import com.png.catalog.vo.PDPReqVO;
import com.png.catalog.vo.PDPRespVO;

/**
 * @author Manish Arora
 *
 */

@org.springframework.web.bind.annotation.RestController
@EnableWebMvc
@ResponseBody
@RequestMapping(value = "/CatalogActor/", headers = "Accept=*/*", produces = "application/json")
public class CatalogActorController extends BaseController {

	private ProductDetailsManager pdpManager;
	private ProductDetailsReqTranslator pdpTranslator;
	private ProductDetailsValidator pdpValidator;
	private CatalogManager catalogManager;

	/**
	 * @return the catalogManager
	 */
	public CatalogManager getCatalogManager() {
		return catalogManager;
	}

	/**
	 * @param catalogManager the catalogManager to set
	 */
	public void setCatalogManager(CatalogManager catalogManager) {
		this.catalogManager = catalogManager;
	}

	@RequestMapping(value = "/getProduct/", method = RequestMethod.GET)
	public ResponseVO getPDPContent(HttpServletRequest request,
			HttpServletResponse response) {

		//initialSetup();
		
		ResponseVO responseVO = new ResponseVO();

		String json = getJSON(request);
		PDPReqVO pdpReqVO = (PDPReqVO) pdpTranslator.translateRequest(
				PDPReqVO.class, json);
		ErrorMap emap = pdpValidator.validate(pdpReqVO);
		if (emap.getErrorCode()!=null) {
			responseVO.setErrorMap(emap);
		} else {
		PDPRespVO pdpResVO = pdpManager.getProductDetails(pdpReqVO
				.getProductId(),emap);
		Output output = new Output(pdpResVO);
		responseVO.setErrorMap(emap);
		responseVO.setOutput(output);
		}
		
		responseVO.setServiceCode(BaseConstants.SERVICE_SUCCESS_CODE);
		responseVO.setServiceMessage(BaseConstants.SERVICE_SUCCESS_MSG);
		return responseVO;
	}
	
	@RequestMapping(value = "/getGlobalNav/", method = RequestMethod.GET)
	public ResponseVO getGlobalNav(HttpServletRequest request,
			HttpServletResponse response) {

		
		ResponseVO responseVO = new ResponseVO();

		
		GlobalNavRespVO navResVO = getCatalogManager().getGlobalNav();
		Output output = new Output(navResVO);
		responseVO.setOutput(output);
		
		responseVO.setServiceCode(BaseConstants.SERVICE_SUCCESS_CODE);
		responseVO.setServiceMessage(BaseConstants.SERVICE_SUCCESS_MSG);
		return responseVO;
	}

	/**
	 * 
	 */
	private void initialSetup() {

		initVku();
		initSkus();
		initProduct();
		initChldCategories();
		initSubCategories();
		initCategory();
		initCatalog();

	}

	/**
	 * 
	 */
	private void initCategory() {

		Banner b11 = new Banner();
		b11.setBannerImage("/docs/images/catalog/banner/Banner_B1.jpg");
		b11.setDestCategoryUrl("/category/");
		b11.setDestCategoryId("chldCat001");
		b11.setDestProductId("prod1");
		b11.setDestProductUrl("/product/");
		b11.setName("Promo Banner 1");
		b11.setPriority(1);
		b11.setTabText("sample promo text 1");

		Banner b12 = new Banner();
		b12.setBannerImage("/docs/images/catalog/banner/Banner_B2.jpg");
		b12.setDestCategoryUrl("/category/");
		b12.setDestCategoryId("chldCat001");
		b12.setDestProductId("prod1");
		b12.setDestProductUrl("/product/");
		b12.setName("Promo Banner 2");
		b12.setPriority(2);
		b12.setTabText("sample promo text 2");

		List<Banner> bannerList = new ArrayList<Banner>();
		bannerList.add(b11);
		bannerList.add(b12);

		List<String> childCategories1 = new ArrayList<String>();
		childCategories1.add("cat005");
		childCategories1.add("cat006");

		List<String> childCategories2 = new ArrayList<String>();
		childCategories2.add("cat007");
		childCategories2.add("cat008");

		List<String> childCategories3 = new ArrayList<String>();
		childCategories3.add("cat009");
		childCategories3.add("cat010");

		List<String> childCategories4 = new ArrayList<String>();
		childCategories4.add("cat011");
		childCategories4.add("cat012");

		Category c1 = new Category();
		c1.setCategoryId("cat001");
		c1.setThumbnailImage("/docs/images/catalog/category/Thumb_C1.jpg");
		c1.setBanners(bannerList);
		c1.setName("Electronics");
		c1.setParentCategoryId("none - this is parent");
		c1.setRoot(true);
		c1.setChildCategories(childCategories1);

		Category c2 = new Category();
		c2.setCategoryId("cat002");
		c2.setThumbnailImage("/docs/images/catalog/category/Thumb_C2.jpg");
		c2.setBanners(bannerList);
		c2.setName("Kids");
		c2.setParentCategoryId("none - this is parent");
		c2.setRoot(true);
		c2.setChildCategories(childCategories2);

		Category c3 = new Category();
		c3.setCategoryId("cat003");
		c3.setThumbnailImage("/docs/images/catalog/category/Thumb_C3.jpg");
		c3.setBanners(bannerList);
		c3.setName("Sports");
		c3.setParentCategoryId("none - this is parent");
		c3.setRoot(true);
		c3.setChildCategories(childCategories3);

		Category c4 = new Category();
		c4.setCategoryId("cat004");
		c4.setThumbnailImage("/docs/images/catalog/category/Thumb_C4.jpg");
		c4.setBanners(bannerList);
		c4.setName("Art");
		c4.setParentCategoryId("none - this is parent");
		c4.setRoot(true);
		c4.setChildCategories(childCategories4);

		pdpManager.createCatalogItem(c1);
		pdpManager.createCatalogItem(c2);
		pdpManager.createCatalogItem(c3);
		pdpManager.createCatalogItem(c4);

	}

	/**
	 * 
	 */
	private void initVku() {
		
		Vku vku = new Vku();
				
		VkuPricePoint vpp = new VkuPricePoint();
		vpp.setFullRetailPrice(40000);
		vpp.setOfferBuyOption(false);
		vpp.setOfferBuyPrice(12000);
		
		vku.setPermitStartDate("01-03-2016");
		vku.setPermitEndDate("30-05-2016");
		vku.setVendorId("vend0001");
		vku.setSkuId("sku0001");
		vku.setVkuId("vku0001");
		vku.setVkuPricePoint(vpp);
		
		pdpManager.createCatalogItem(vku);

	}

	/**
	 * 
	 */
	private void initSkus() {
		
		List<String> vkus = new ArrayList<String>();
		vkus.add("vku0001");
		
		List<SkuImage> sil1 = new ArrayList<SkuImage>();
		SkuImage si1 = new SkuImage();
		si1.setLargeImage("/docs/images/catalog/sku/Large_S1.jpg");
		si1.setMedIMage("/docs/images/catalog/sku/Med_S1.jpg");
		si1.setSmallImage("/docs/images/catalog/sku/Small_S1.jpg");
		si1.setThumbnailImage("/docs/images/catalog/sku/Thumb_S1.jpg");
		sil1.add(si1);
		
		
		SkuPricePoint pp = new SkuPricePoint();
		pp.setDailyPrice( 500);
		pp.setMonthlyPrice(10000);
		pp.setQuaterlyPrice(25000);
		pp.setWeeklyPrice(3000);
		pp.setDeposit(3000);
		
		
		Sku sku1 = new Sku();
		sku1.setName("Sony PlayStation 4 (PS4) 500 GB(Black)");
		sku1.setDescription("A single-chip custom processor ensures that your games run without a glitch while the 8 core Jaguar low power x86-64 AMD CPU allows for a smooth flow. ");
		sku1.setParentProductId("prd0001");
		sku1.setSkuId("sku0001");	
		sku1.setSkuImage(sil1);
		sku1.setSkuPricePoint(pp);
		sku1.setVkus(vkus);  
		
		pdpManager.createCatalogItem(sku1);

	}

	/**
	 * 
	 */
	private void initProduct() {
		
		List<ProductImage> pi = new ArrayList<ProductImage>();
		ProductImage i1 = new ProductImage();
		i1.setLargeImage("/docs/images/catalog/product/Large_P1.jpg");
		i1.setMedIMage("/docs/images/catalog/product/Med_P1.jpg");
		i1.setSmallImage("/docs/images/catalog/product/Small_P1.jpg");
		i1.setThumbnailImage("/docs/images/catalog/product/ThuRmb_P1.jpg");
		
		List<String> recommendedProducts = new ArrayList<String>();
		recommendedProducts.add("prd1001");
		recommendedProducts.add("prd1002");
		
		List<String> skus = new ArrayList<String>();
		skus.add("sku0001");
		
		List<String> whatsIncluded = new ArrayList<String>();
		whatsIncluded.add("1 Gaming Console");
		whatsIncluded.add("1 Wireless Controller");
		whatsIncluded.add("1 Power Cord");
		whatsIncluded.add("1 USB Cable for charging Controller");
		whatsIncluded.add("1 HDMI Cable");
		whatsIncluded.add("1 VGA Cable");

		Product prod1 = new Product();
		prod1.setProductId("prd0001");
		prod1.setName("Sony PlayStation 4 (PS4) 500 GB");
		prod1.setAggregateRating( 4.6);
		prod1.setDescription("Features such as an exceptional graphics performance and a customized memory make the PlayStation4 an immersive gaming experience. A processor that is 10 times more powerful than the PlayStation3 creates a setting that is bigger and bolder.");
		prod1.setNumOfReviews(133);
		prod1.setBrand("Sony");
		prod1.setWhatsIncluded(whatsIncluded);
		prod1.setParentCategoryId("cat005");
		pi.add(i1);
		prod1.setProductImage(pi);
		prod1.setRecommendedProducts(recommendedProducts);
		prod1.setSkus(skus);
		
		
		
		List<ProductImage> pi2 = new ArrayList<ProductImage>();
		ProductImage i12 = new ProductImage();
		i12.setLargeImage("/docs/images/catalog/product/Large_P12.jpg");
		i12.setMedIMage("/docs/images/catalog/product/Med_P12.jpg");
		i12.setSmallImage("/docs/images/catalog/product/Small_P12.jpg");
		i12.setThumbnailImage("/docs/images/catalog/product/Thumb_P12.jpg");
		
		List<String> recommendedProducts2 = new ArrayList<String>();
		recommendedProducts2.add("prd2001");
		recommendedProducts2.add("prd2002");
		
		List<String> skus2 = new ArrayList<String>();
		skus2.add("sku0002");
		
		List<String> whatsIncluded2 = new ArrayList<String>();
		whatsIncluded2.add("1 Stroller");
		whatsIncluded2.add("Cup holder for 2 cups");
		whatsIncluded2.add("Safety Latch");

		Product prod2 = new Product();
		prod2.setProductId("prd0002");
		prod2.setName("Luvlap Baby Stroller");
		prod2.setAggregateRating( 4.6);
		prod2.setDescription("Make your little angel’s outdoor trips more safe and secure with the help of this Luvlap Baby Stroller that comes in an attractive print.");
		prod2.setNumOfReviews(43);
		prod2.setBrand("Luvlap");
		prod2.setWhatsIncluded(whatsIncluded2);
		prod2.setParentCategoryId("cat007");
		pi2.add(i12);
		prod2.setProductImage(pi2);
		prod2.setRecommendedProducts(recommendedProducts2);
		prod2.setSkus(skus2);
		
		
		Product prod3 = new Product();
		prod3.setProductId("prd0003");
		prod3.setName("Sony PlayStation 4 (PS4) 1 TB");
		prod3.setAggregateRating( 4.6);
		prod3.setDescription("Features such as an exceptional graphics performance and a customized memory make the PlayStation4 an immersive gaming experience. A processor that is 10 times more powerful than the PlayStation3 creates a setting that is bigger and bolder.");
		prod3.setNumOfReviews(133);
		prod3.setBrand("Sony");
		prod3.setWhatsIncluded(whatsIncluded);
		prod3.setParentCategoryId("chldCat001");
		prod3.setProductImage(pi);
		prod3.setRecommendedProducts(recommendedProducts);
		prod3.setSkus(skus);
		
		Product prod4 = new Product();
		prod4.setProductId("prd0004");
		prod4.setName("Sony WIFI 8 (W8) 1 TB");
		prod4.setAggregateRating( 4.6);
		prod4.setDescription("Features such as an exceptional graphics performance and a customized memory make the PlayStation4 an immersive gaming experience. A processor that is 10 times more powerful than the PlayStation3 creates a setting that is bigger and bolder.");
		prod4.setNumOfReviews(133);
		prod4.setBrand("Sony");
		prod4.setWhatsIncluded(whatsIncluded);
		prod4.setParentCategoryId("chldCat001");
		prod4.setProductImage(pi);
		prod4.setRecommendedProducts(recommendedProducts);
		prod4.setSkus(skus);
		
		pdpManager.createCatalogItem(prod1);
		pdpManager.createCatalogItem(prod2);
		pdpManager.createCatalogItem(prod3);
		pdpManager.createCatalogItem(prod4);
		
		
	}

	/**
	 * 
	 */
	private void initSubCategories() {

		List<String> chldProd1 = new ArrayList<String>();
		chldProd1.add("prd0001");
		chldProd1.add("prd0002");

		
		List<String> childCategories1 = new ArrayList<String>();
		childCategories1.add("chldCat001");
		childCategories1.add("chldCat002");
		
		Category c1 = new Category();
		c1.setCategoryId("cat005");
		c1.setThumbnailImage("/docs/images/catalog/category/Thumb_CC1.jpg");
		c1.setName("Gaming");
		c1.setParentCategoryId("cat001");
		c1.setRoot(false);
		c1.setChildProducts(chldProd1);

		Category c2 = new Category();
		c2.setCategoryId("cat007");
		c2.setThumbnailImage("/docs/images/catalog/category/Thumb_CC2.jpg");
		c2.setName("Toys");
		c2.setParentCategoryId("cat002");
		c2.setRoot(false);
		c2.setChildCategories(childCategories1);
		

		Category c3 = new Category();
		c3.setCategoryId("cat009");
		c3.setThumbnailImage("/docs/images/catalog/category/Thumb_CC3.jpg");
		c3.setName("Cricket");
		c3.setParentCategoryId("cat003");
		c3.setRoot(false);
		

		Category c4 = new Category();
		c4.setCategoryId("cat011");
		c4.setThumbnailImage("/docs/images/catalog/category/Thumb_CC4.jpg");
		c4.setName("Music Instruments");
		c4.setParentCategoryId("cat004");
		c4.setRoot(false);
		

		pdpManager.createCatalogItem(c1);
		pdpManager.createCatalogItem(c2);
		pdpManager.createCatalogItem(c3);
		pdpManager.createCatalogItem(c4);

	}
	
	
	private void initChldCategories() {

		List<String> chldProd1 = new ArrayList<String>();
		chldProd1.add("prd0003");
		chldProd1.add("prd0004");

		
		Category c1 = new Category();
		c1.setCategoryId("chldCat001");
		c1.setThumbnailImage("/docs/images/catalog/category/Thumb_CC1.jpg");
		c1.setName("Child 1 of Toys");
		c1.setParentCategoryId("cat007");
		c1.setRoot(false);
		c1.setChildProducts(chldProd1);

		Category c2 = new Category();
		c2.setCategoryId("chldCat002");
		c2.setThumbnailImage("/docs/images/catalog/category/Thumb_CC2.jpg");
		c2.setName("Child 2 of Toys");
		c2.setParentCategoryId("cat007");
		c2.setRoot(false);
		c2.setChildProducts(chldProd1);

		

		pdpManager.createCatalogItem(c1);
		pdpManager.createCatalogItem(c2);
	

	}

	/**
	 * 
	 */
	private void initCatalog() {

		Catalog catalog = new Catalog();
		catalog.setCatalogId("catalog01");
		catalog.setName("OR Catalog");
		catalog.setDescription("Base catalog for OR");
		List<String> rootCategories = new ArrayList<String>();
		rootCategories.add("cat001"); // electronics
		rootCategories.add("cat002"); // kids
		rootCategories.add("cat003"); // sports
		rootCategories.add("cat004"); // Art
		catalog.setRootCategories(rootCategories);
		pdpManager.createCatalogItem(catalog);

	}


	public ProductDetailsManager getPdpManager() {
		return pdpManager;
	}

	public void setPdpManager(ProductDetailsManager pdpManager) {
		this.pdpManager = pdpManager;
	}

	public ProductDetailsReqTranslator getPdpTranslator() {
		return pdpTranslator;
	}

	public void setPdpTranslator(ProductDetailsReqTranslator pdpTranslator) {
		this.pdpTranslator = pdpTranslator;
	}

	public ProductDetailsValidator getPdpValidator() {
		return pdpValidator;
	}

	public void setPdpValidator(ProductDetailsValidator pdpValidator) {
		this.pdpValidator = pdpValidator;
	}

}

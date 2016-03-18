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
import com.png.base.ErrorMap;
import com.png.catalog.Entity.Banner;
import com.png.catalog.Entity.Catalog;
import com.png.catalog.Entity.Category;
import com.png.catalog.Entity.Product;
import com.png.catalog.Entity.ProductImage;
import com.png.catalog.Entity.Sku;
import com.png.catalog.Entity.SkuImage;
import com.png.catalog.Entity.SkuPricePoint;
import com.png.catalog.req.vo.PDPReqVO;

/**
 * @author Manish Arora
 *
 */

@org.springframework.web.bind.annotation.RestController
@EnableWebMvc
@ResponseBody
@RequestMapping(value = "/ProductActor/", headers = "Accept=*/*", produces = "application/json")
public class ProductActorController {

	private ProductDetailsManager pdpManager;
	private ProductDetailsReqTranslator pdpTranslator;
	private ProductDetailsValidator pdpValidator;

	@RequestMapping(value = "/getProduct/", method = RequestMethod.GET)
	public PDPRespVO getPDPContent(HttpServletRequest request,
			HttpServletResponse response) {

		initialSetup();

		String json = getJSON(request);
		PDPReqVO pdpReqVO = (PDPReqVO) pdpTranslator.translateRequest(
				PDPReqVO.class, json);
		ErrorMap emap = pdpValidator.validate(pdpReqVO);
		PDPRespVO pdpResVO = pdpManager.getProductDetails(pdpReqVO
				.getProductId());
		pdpResVO.setErrorMap(emap);
		return pdpResVO;
	}

	/**
	 * 
	 */
	private void initialSetup() {

		initCatalog();
		initCategory();
		initChldCategories();
		initProduct();
		initSkus();
		initRecommendedProducts();
		initVku();

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
		c3.setCategoryId("cat03");
		c3.setThumbnailImage("/docs/images/catalog/category/Thumb_C3.jpg");
		c3.setBanners(bannerList);
		c3.setName("Sports");
		c3.setParentCategoryId("none - this is parent");
		c3.setRoot(true);
		c3.setChildCategories(childCategories3);

		Category c4 = new Category();
		c4.setCategoryId("cat001");
		c4.setThumbnailImage("/docs/images/catalog/category/Thumb_C4.jpg");
		c4.setBanners(bannerList);
		c4.setName("Art");
		c4.setParentCategoryId("none - this is parent");
		c4.setRoot(true);
		c4.setChildCategories(childCategories4);

		pdpManager.createCategory(c1);
		pdpManager.createCategory(c2);
		pdpManager.createCategory(c3);
		pdpManager.createCategory(c4);

	}

	/**
	 * 
	 */
	private void initVku() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	private void initRecommendedProducts() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	private void initSkus() {
		
		
		List<SkuImage> sil1 = new ArrayList<SkuImage>();
		SkuImage si1 = new SkuImage();
		si1.setLargeImage("/docs/images/catalog/sku/Large_S1.jpg");
		si1.setMedIMage("/docs/images/catalog/sku/Med_S1.jpg");
		si1.setSmallImage("/docs/images/catalog/sku/Small_S1.jpg");
		si1.setThumbnailImage("/docs/images/catalog/sku/Thumb_S1.jpg");
		sil1.add(si1);
		
		
		SkuPricePoint pp = new SkuPricePoint();
		pp.setDailyPrice((float) 500);
		pp.setMonthlyPrice((float)10000);
		pp.setQuaterlyPrice((float)25000);
		pp.setWeeklyPrice((float)3000);
		
		
		Sku sku1 = new Sku();
		sku1.setName("Sony PlayStation 4 (PS4) 500 GB(Black)");
		sku1.setDescription("A single-chip custom processor ensures that your games run without a glitch while the 8 core Jaguar low power x86-64 AMD CPU allows for a smooth flow. ");
		sku1.setParentProductId("prd0001");
		sku1.setSkuId("sku0001");	
		sku1.setSkuImage(sil1);
		sku1.setSkuPricePoint(pp);
		//sku1.setVkus(vkus);  ***********Pending***********

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
		i1.setThumbnailImage("/docs/images/catalog/product/Thumb_P1.jpg");
		
		List<String> recommendedProducts = new ArrayList<String>();
		recommendedProducts.add("prd1001");
		recommendedProducts.add("prd1002");
		
		List<String> skus = new ArrayList<String>();
		skus.add("sku0001");

		Product prod1 = new Product();
		prod1.setProductId("prd0001");
		prod1.setName("Sony PlayStation 4 (PS4) 500 GB");
		prod1.setAggregateRating((float) 4.6);
		prod1.setDescription("Features such as an exceptional graphics performance and a customized memory make the PlayStation4 an immersive gaming experience. A processor that is 10 times more powerful than the PlayStation3 creates a setting that is bigger and bolder.");
		prod1.setNumOfReviews(133);
		prod1.setParentCategoryId("chldCat001");
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

		Product prod2 = new Product();
		prod2.setProductId("prd0002");
		prod2.setName("Luvlap Baby Stroller");
		prod2.setAggregateRating((float) 4.6);
		prod2.setDescription("Make your little angel’s outdoor trips more safe and secure with the help of this Luvlap Baby Stroller that comes in an attractive print.");
		prod2.setNumOfReviews(43);
		prod2.setParentCategoryId("chldCat002");
		pi2.add(i12);
		prod2.setProductImage(pi2);
		prod2.setRecommendedProducts(recommendedProducts2);
		prod2.setSkus(skus2);
		
		
	}

	/**
	 * 
	 */
	private void initChldCategories() {

		List<String> chldProd1 = new ArrayList<String>();
		chldProd1.add("prd0001");
		chldProd1.add("prd0002");

		List<String> chldProd2 = new ArrayList<String>();
		chldProd1.add("prd0003");
		chldProd1.add("prd0004");

		List<String> chldProd3 = new ArrayList<String>();
		chldProd1.add("prd0005");
		chldProd1.add("prd0006");

		List<String> chldProd4 = new ArrayList<String>();
		chldProd1.add("prd0007");
		chldProd1.add("prd0008");

		Category c1 = new Category();
		c1.setCategoryId("chldCat001");
		c1.setThumbnailImage("/docs/images/catalog/category/Thumb_CC1.jpg");
		c1.setName("Gaming");
		c1.setParentCategoryId("cat001");
		c1.setRoot(false);
		c1.setChildProducts(chldProd1);

		Category c2 = new Category();
		c2.setCategoryId("chldCat002");
		c2.setThumbnailImage("/docs/images/catalog/category/Thumb_CC2.jpg");
		c2.setName("Toys");
		c2.setParentCategoryId("cat002");
		c2.setRoot(false);
		c2.setChildProducts(chldProd2);

		Category c3 = new Category();
		c3.setCategoryId("chldCat003");
		c3.setThumbnailImage("/docs/images/catalog/category/Thumb_CC3.jpg");
		c3.setName("Cricket");
		c3.setParentCategoryId("cat003");
		c3.setRoot(false);
		c3.setChildProducts(chldProd3);

		Category c4 = new Category();
		c4.setCategoryId("chldCat004");
		c4.setThumbnailImage("/docs/images/catalog/category/Thumb_CC4.jpg");
		c4.setName("Music Instruments");
		c4.setParentCategoryId("cat004");
		c4.setRoot(false);
		c4.setChildProducts(chldProd4);

		pdpManager.createCategory(c1);
		pdpManager.createCategory(c2);
		pdpManager.createCategory(c3);
		pdpManager.createCategory(c4);

	}

	/**
	 * 
	 */
	private void initCatalog() {

		Catalog catalog = new Catalog();
		catalog.setName("OR Catalog");
		catalog.setDescription("Base catalog for OR");
		List<String> rootCategories = new ArrayList<String>();
		rootCategories.add("cat001"); // electronics
		rootCategories.add("cat002"); // kids
		rootCategories.add("cat003"); // sports
		rootCategories.add("cat004"); // Art
		catalog.setRootCategories(rootCategories);
		pdpManager.createCatalog(catalog);

	}

	/**
	 * @param request
	 * @return
	 */
	private String getJSON(HttpServletRequest request) {

		return request.getParameter(BaseConstants.JSON_DATA);
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

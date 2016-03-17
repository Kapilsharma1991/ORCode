package com.png.catalog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.png.base.BaseConstants;
import com.png.base.ErrorMap;
import com.png.catalog.Entity.Product;
import com.png.catalog.req.vo.PDPReqVO;
import com.png.sample.ProductDetail;

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
	public Product getPDPContent(HttpServletRequest request, HttpServletResponse response) {

		String json = getJSON(request);
		PDPReqVO pdpReqVO = (PDPReqVO) pdpTranslator.translateRequest(PDPReqVO.class, json);
		ErrorMap emap = pdpValidator.validate(pdpReqVO);
		Product product = pdpManager.getProductDetails(pdpReqVO.getProductId());
		PDPRespVO pdpResVO = new PDPRespVO();
		pdpResVO.setErrorMap(emap);
		//pdpResVO.setOutput(new );
		
		
		
		


			/*ProductDetail prd = initializeProduct();
			String prodId = coreTools.createProduct(prd);

			product = coreTools.getProduct(prodId);*/


		return product;
	}

	/**
	 * @param request
	 * @return
	 */
	private String getJSON(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return request.getParameter(BaseConstants.JSON_DATA);
	}

	private ProductDetail initializeProduct() {

		ProductDetail prd = new ProductDetail();
		prd.setName("Sony PLaystation 4");
		prd.setDescription("PlayStation 4 Ultimate player 1 TB Edition bundled with 2 free games - God of War Remastered and The Last of Us Remastered");
		prd.setColor("Black");
		prd.setPrice("RS 40000");
		return prd;
	}

	/*public CoreMongoTools getCoreTools() {
		return coreTools;
	}

	public void setCoreTools(CoreMongoTools coreTools) {
		this.coreTools = coreTools;
	}*/

}

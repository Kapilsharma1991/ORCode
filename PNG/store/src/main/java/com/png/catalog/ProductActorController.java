package com.png.catalog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.png.base.BaseConstants;
import com.png.base.ErrorMap;
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
	public PDPRespVO getPDPContent(HttpServletRequest request, HttpServletResponse response) {

		String json = getJSON(request);
		PDPReqVO pdpReqVO = (PDPReqVO) pdpTranslator.translateRequest(PDPReqVO.class, json);
		ErrorMap emap = pdpValidator.validate(pdpReqVO);
		PDPRespVO pdpResVO = pdpManager.getProductDetails(pdpReqVO.getProductId());
		pdpResVO.setErrorMap(emap);
		return pdpResVO;
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

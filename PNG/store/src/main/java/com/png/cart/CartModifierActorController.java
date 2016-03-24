package com.png.cart;

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
import com.png.cart.vo.CartModifierReqVO;
import com.png.cart.vo.CartModifierRespVO;

/**
 * @author Manish Arora
 *
 */

@org.springframework.web.bind.annotation.RestController
@EnableWebMvc
@ResponseBody
@RequestMapping(value = "/CartActor/", headers = "Accept=*/*", produces = "application/json")
public class CartModifierActorController extends BaseController {

	private CartReqTranslator cartTranslator;
	private CartValidator cartValidator;
	private CartManager cartManager;

	/**
	 * @return the cartTranslator
	 */
	public CartReqTranslator getCartTranslator() {
		return cartTranslator;
	}

	/**
	 * @param cartTranslator
	 *            the cartTranslator to set
	 */
	public void setCartTranslator(CartReqTranslator cartTranslator) {
		this.cartTranslator = cartTranslator;
	}

	/**
	 * @return the cartValidator
	 */
	public CartValidator getCartValidator() {
		return cartValidator;
	}

	/**
	 * @param cartValidator
	 *            the cartValidator to set
	 */
	public void setCartValidator(CartValidator cartValidator) {
		this.cartValidator = cartValidator;
	}

	/**
	 * @return the cartManager
	 */
	public CartManager getCartManager() {
		return cartManager;
	}

	/**
	 * @param cartManager
	 *            the cartManager to set
	 */
	public void setCartManager(CartManager cartManager) {
		this.cartManager = cartManager;
	}

	@RequestMapping(value = "/addToCart/", method = RequestMethod.POST)
	public ResponseVO addToCart(HttpServletRequest request,
			HttpServletResponse response) {

		// initialSetup();

		ResponseVO responseVO = new ResponseVO();

		String json = getJSON(request);

		CartModifierReqVO addToCartReqVO = (CartModifierReqVO) cartTranslator
				.translateRequest(CartModifierReqVO.class, json);
		ErrorMap emap = cartValidator.validate(addToCartReqVO);
		if (emap.getErrorCode()!=null) {
			responseVO.setErrorMap(emap);
		} else {
		CartModifierRespVO addToCartResVO = cartManager.addItemToCart(addToCartReqVO, emap);
		Output output = new Output(addToCartResVO);
		responseVO.setErrorMap(emap);
		responseVO.setOutput(output);
		}
		responseVO.setServiceCode(BaseConstants.SERVICE_SUCCESS_CODE);
		responseVO.setServiceMessage(BaseConstants.SERVICE_SUCCESS_MSG);
		return responseVO;
	}

}

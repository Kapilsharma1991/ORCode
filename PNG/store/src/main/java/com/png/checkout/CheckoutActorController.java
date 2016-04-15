package com.png.checkout;

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
import com.png.checkout.Entity.ShippingGroup;
import com.png.checkout.Entity.ShippingMethod;
import com.png.checkout.constant.CheckoutConstants;
import com.png.checkout.vo.ShippingGroupReqVO;
import com.png.checkout.vo.ShippingGroupResVO;
import com.png.common.Entity.ContactInfo;
import com.png.order.OrderManager;
import com.png.session.SessionManager;

/**
 * @author Manish Arora
 *
 */

@org.springframework.web.bind.annotation.RestController
@EnableWebMvc
@ResponseBody
@RequestMapping(value = "/CheckoutActor/", headers = "Accept=*/*", produces = "application/json")
public class CheckoutActorController extends BaseController {

	private ShippingGroupTranslator shippingGroupTranslator;
	private ShippingGroupValidator shippingGroupValidator;
	private ShippingGroupManager shippingGroupManager;

	private OrderManager orderManager;
	
	public OrderManager getOrderManager() {
		return orderManager;
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	
	public ShippingGroupTranslator getShippingGroupTranslator() {
		return shippingGroupTranslator;
	}

	public void setShippingGroupTranslator(
			ShippingGroupTranslator shippingGroupTranslator) {
		this.shippingGroupTranslator = shippingGroupTranslator;
	}
	
	
	

	/**
	 * @return shippingGroupValidator
	 */
	public ShippingGroupValidator getShippingGroupValidator() {
		return shippingGroupValidator;
	}

	/**
	 * @param shippingGroupValidator
	 */
	public void setShippingGroupValidator(
			ShippingGroupValidator shippingGroupValidator) {
		this.shippingGroupValidator = shippingGroupValidator;
	}

	/**
	 * @return shippingGroupManager
	 */
	public ShippingGroupManager getShippingGroupManager() {
		return shippingGroupManager;
	}

	/**
	 * @param shippingGroupManager
	 */
	public void setShippingGroupManager(ShippingGroupManager shippingGroupManager) {
		this.shippingGroupManager = shippingGroupManager;
	}	

	@RequestMapping(value = "/addShipping/", method = RequestMethod.POST)
	public ResponseVO addShippingGroup(HttpServletRequest request,
			HttpServletResponse response) {
		
		ResponseVO responseVO = new ResponseVO();
		String json = getJSON(request);
		
		ShippingGroupReqVO shippingReq =  (ShippingGroupReqVO)shippingGroupTranslator.translateRequest(ShippingGroupReqVO.class, json);
		ErrorMap emap = shippingGroupValidator.validate(shippingReq, CheckoutConstants.ACTION_ADD_NEW_SHIPPING_GROUP);
		if (emap.getErrorCode() != null) {
			responseVO.setErrorMap(emap);
		} else {
			String shippingGrpId = "";
			ContactInfo contactInfo = null;
			String  retContactInfoId  = shippingGroupManager.createShippingContactInfo(shippingReq);
			ShippingMethod  shippingMethod  = shippingGroupManager.getShippingMethodByShippingMethodId(shippingReq.getShippingMethodId());
			if(!retContactInfoId.isEmpty()){
				contactInfo = shippingGroupManager.getContactInfoItemById(retContactInfoId);
			}
			if(retContactInfoId != null ){
				ShippingGroup shippGrp = new ShippingGroup();
				shippGrp.setContactInfoId(contactInfo.getId());
				shippGrp.setShippingMethodId(shippingMethod.getId());
				
				shippingGrpId = (String)shippingGroupManager.createShippingGroup(shippGrp);
				orderManager.getOrder().setShippingGroupId(shippingGrpId);
			}
			
			
			ShippingGroupResVO shippingResvo = new ShippingGroupResVO();
			
			shippingResvo.setShippingGroupId(shippingGrpId);
			shippingResvo.setContactInfo(contactInfo);
			shippingResvo.setShippingMethod(shippingMethod);
			Output output = new Output(shippingResvo);
			responseVO.setErrorMap(emap);
			responseVO.setOutput(output);
		}
		
		responseVO.setServiceCode(BaseConstants.SERVICE_SUCCESS_CODE);
		responseVO.setServiceMessage(BaseConstants.SERVICE_SUCCESS_MSG);
		return responseVO;
		
	}	
}
	


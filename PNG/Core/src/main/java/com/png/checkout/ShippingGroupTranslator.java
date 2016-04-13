/**
 * 
 */
package com.png.checkout;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.png.base.BaseTranslator;
import com.png.cart.constant.CartConstants;
import com.png.cart.vo.CartDetailsReqVO;
import com.png.cart.vo.CartModifierReqVO;
import com.png.catalog.constant.CatalogConstants;
import com.png.catalog.vo.PDPReqVO;
import com.png.checkout.constant.CheckoutConstants;
import com.png.checkout.vo.ShippingGroupReqVO;
import com.png.myacc.constant.UserProfileConstants;
import com.png.myacc.vo.UserProfileReqVO;

/**
 * @author Manish Arora
 *
 */
public class ShippingGroupTranslator extends BaseTranslator {
	
	public <T> Object translateRequest(Class<T> theClass, String jsonData) {

		Object obj = null;
		ObjectMapper mapper = new ObjectMapper();

		try {

			if (theClass.getName().equalsIgnoreCase(
					CheckoutConstants.CLASS_SHIPPING_GROUP_REQ_VO)) {

				obj = mapper.readValue(jsonData, ShippingGroupReqVO.class);

			} 
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;

	}

}



package com.png.base;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.png.cart.constant.CartConstants;
import com.png.cart.vo.CartModifierReqVO;
import com.png.catalog.constant.CatalogConstants;
import com.png.catalog.vo.PDPReqVO;

/**
 * @author Manish Arora
 *
 */
public class BaseTranslator {
	
	public <T> Object translateRequest(Class<T> theClass, String jsonData)  {
		
		Object obj = null;
		ObjectMapper mapper = new ObjectMapper();
	
		
		if (theClass.getName().equalsIgnoreCase(CatalogConstants.CLASS_PDP_REQ_VO)) {
			
			try {
				obj = mapper.readValue(jsonData, PDPReqVO.class);
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
			
		} else 	if (theClass.getName().equalsIgnoreCase(CartConstants.CLASS_CART_MODIFIER_REQ_VO)) {
			
			try {
				obj = mapper.readValue(jsonData, CartModifierReqVO.class);
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
			
		}
		
		
		return obj;
		
	}
	
	public  <T> T getInstance(Class<T> theClass) {
		
		T t = null;

		    try {
				t = theClass.newInstance();
			} catch (InstantiationException e) {
			
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			}
			return t;
		}

}

package com.png.base;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.png.catalog.req.vo.PDPReqVO;

/**
 * @author Manish Arora
 *
 */
public class BaseTranslator {
	
	public <T> Object translateRequest(Class<T> theClass, String jsonData)  {
		
		Object obj = null;
		ObjectMapper mapper = new ObjectMapper();
	
		
		if (theClass.getName().equalsIgnoreCase("PDPReqVO")) {
			//obj = getInstance(PDPReqVO.class);
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

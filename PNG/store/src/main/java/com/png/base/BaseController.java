/**
 * 
 */
package com.png.base;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Manish Arora
 *
 */
public class BaseController {

	/**
	 * @param request
	 * @return
	 */
	protected String getJSON(HttpServletRequest request) {

		return request.getParameter(BaseConstants.JSON_DATA);
	}

	
}



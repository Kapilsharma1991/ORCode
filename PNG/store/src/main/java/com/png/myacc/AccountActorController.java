package com.png.myacc;

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
import com.png.myacc.constant.UserProfileConstants;
import com.png.myacc.vo.UserProfileReqVO;
import com.png.myacc.vo.UserProfileRespVO;

/**
 * @author Manish Arora
 *
 */

@org.springframework.web.bind.annotation.RestController
@EnableWebMvc
@ResponseBody
@RequestMapping(value = "/AccountActor/", headers = "Accept=*/*", produces = "application/json")
public class AccountActorController extends BaseController {

	private UserProfileTranslator userProfileTranslator;
	private UserProfileValidator userProfileValidator;
	private UserProfileManager userProfileManager;

	/**
	 * @return the userProfileTranslator
	 */
	public UserProfileTranslator getUserProfileTranslator() {
		return userProfileTranslator;
	}

	/**
	 * @param userProfileTranslator the userProfileTranslator to set
	 */
	public void setUserProfileTranslator(UserProfileTranslator userProfileTranslator) {
		this.userProfileTranslator = userProfileTranslator;
	}

	/**
	 * @return the userProfileValidator
	 */
	public UserProfileValidator getUserProfileValidator() {
		return userProfileValidator;
	}

	/**
	 * @param userProfileValidator the userProfileValidator to set
	 */
	public void setUserProfileValidator(UserProfileValidator userProfileValidator) {
		this.userProfileValidator = userProfileValidator;
	}

	/**
	 * @return the userProfileManager
	 */
	public UserProfileManager getUserProfileManager() {
		return userProfileManager;
	}

	/**
	 * @param userProfileManager the userProfileManager to set
	 */
	public void setUserProfileManager(UserProfileManager userProfileManager) {
		this.userProfileManager = userProfileManager;
	}

	@RequestMapping(value = "/createUser/", method = RequestMethod.POST)
	public ResponseVO createUser(HttpServletRequest request,
			HttpServletResponse response) {

		ResponseVO responseVO = new ResponseVO();

		String json = getJSON(request);

		UserProfileReqVO userProfileReqVO = (UserProfileReqVO) userProfileTranslator
				.translateRequest(UserProfileReqVO.class, json);
		ErrorMap emap = userProfileValidator.validate(userProfileReqVO,
				UserProfileConstants.ACTION_CREATE_USER);
		if (emap.getErrorCode() != null) {
			responseVO.setErrorMap(emap);
		} else {
			UserProfileRespVO userProfileResVO = userProfileManager.createUser(
					userProfileReqVO, emap);
			Output output = new Output(userProfileResVO);
			responseVO.setErrorMap(emap);
			responseVO.setOutput(output);
		}
		responseVO.setServiceCode(BaseConstants.SERVICE_SUCCESS_CODE);
		responseVO.setServiceMessage(BaseConstants.SERVICE_SUCCESS_MSG);
		return responseVO;
	}

}

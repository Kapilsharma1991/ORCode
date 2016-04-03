/**
 * 
 */
package com.png.myacc;

import com.png.base.BaseConstants;
import com.png.base.BaseManager;
import com.png.base.ErrorMap;
import com.png.myacc.Entity.UserProfile;
import com.png.myacc.constant.UserProfileConstants;
import com.png.myacc.constant.UserProfileErrorMsgConstants;
import com.png.myacc.vo.UserProfileReqVO;
import com.png.myacc.vo.UserProfileRespVO;

/**
 * @author Manish Arora
 *
 */
public class UserProfileManager extends BaseManager {
	
	private ProfileTools profileTools;

	/**
	 * @return the profileTools
	 */
	public ProfileTools getProfileTools() {
		return profileTools;
	}

	/**
	 * @param profileTools the profileTools to set
	 */
	public void setProfileTools(ProfileTools profileTools) {
		this.profileTools = profileTools;
	}

	/**
	 * @param userProfileReqVO
	 * @param emap
	 * @return
	 */
	public UserProfileRespVO createUser(UserProfileReqVO userReqVO,
			ErrorMap emap) {

		UserProfileRespVO profileResponseVO = new UserProfileRespVO();
		if (isEmailIdAlreadyUsed(userReqVO.getEmailId())) {
			emap.setErrorCode(BaseConstants.ERROR_CODE_ONE);
			emap.setErrorMessage(UserProfileErrorMsgConstants.EMAIL_ID_ALREDAY_IN_USE);
			return profileResponseVO;
		} else {
			UserProfile profile = translateToUserProfile(userReqVO);
			profile.setAccountStatus(UserProfileConstants.ACCOUNT_ACTIVE);
			profileTools.createUser(profile);
			profileResponseVO.setFirstName(profile.getFirstName());
			
		}
			

		return profileResponseVO;
	}

	/**
	 * @param userReqVO
	 * @return
	 */
	private UserProfile translateToUserProfile(UserProfileReqVO userReqVO) {
		
		UserProfile profile = new  UserProfile();
		profile.setEmailId(userReqVO.getEmailId());
		profile.setFirstName(userReqVO.getFirstName());
		profile.setLastName(userReqVO.getLastName());
		profile.setPassword(userReqVO.getPassword());
		profile.setPhoneNum(userReqVO.getPhoneNumber());
		return profile;
	}

	/**
	 * @param emailId
	 * @return
	 */
	private boolean isEmailIdAlreadyUsed(String emailId) {
		
		return profileTools.isEmailIdAlreadyUsed(emailId);
	}

}

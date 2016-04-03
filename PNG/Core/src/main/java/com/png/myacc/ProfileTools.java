/**
 * 
 */
package com.png.myacc;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.png.myacc.Entity.UserProfile;

/**
 * @author Manish Arora
 *
 */
public class ProfileTools {
	
	private MongoTemplate coreMongoTemplate;


	/**
	 * @return the coreMongoTemplate
	 */
	public MongoTemplate getCoreMongoTemplate() {
		return coreMongoTemplate;
	}


	/**
	 * @param coreMongoTemplate the coreMongoTemplate to set
	 */
	public void setCoreMongoTemplate(MongoTemplate coreMongoTemplate) {
		this.coreMongoTemplate = coreMongoTemplate;
	}


	/**
	 * @param emailId
	 */
	public boolean isEmailIdAlreadyUsed(String emailId) {
		
		boolean ret = true;

		Query query = new Query(Criteria.where("emailId").is(emailId));	
		
		List<UserProfile> users = coreMongoTemplate.find(query, UserProfile.class);
		if ( null == users || users.size() == 0) {
			ret =  false;
		} 
		
		return ret;
	}


	/**
	 * @param profile
	 */
	public void createUser(UserProfile profile) {
		
		coreMongoTemplate.save(profile);
		
	}

}



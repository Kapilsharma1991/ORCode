package com.png.checkout;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.png.checkout.Entity.ShippingGroup;
import com.png.checkout.Entity.ShippingMethod;
import com.png.common.Entity.ContactInfo;
import com.png.order.Entity.Order;

public class ShippingTools {
	
	private MongoTemplate coreMongoTemplate;

	
	
	public MongoTemplate getCoreMongoTemplate() {
		return coreMongoTemplate;
	}



	public void setCoreMongoTemplate(MongoTemplate coreMongoTemplate) {
		this.coreMongoTemplate = coreMongoTemplate;
	}



	public String createContactInfoItem(ContactInfo cInfo) {
			
			coreMongoTemplate.save(cInfo);
			return cInfo.getId();
		}
	
	public ContactInfo getContactInfoItemByContactInfoId(String contactInfoId) {
		ContactInfo ci = null;
		Query query = new Query(Criteria.where("contactInfoId").is(contactInfoId));
		List<ContactInfo>  listContactInfo = coreMongoTemplate.find(query, ContactInfo.class);
		if(listContactInfo.size() != 0 && listContactInfo != null){
			ci =  listContactInfo.get(0);
		}
		return ci;
	}
	
	public ContactInfo getContactInfoItemById(String id) {
		ContactInfo ci = null;
		Query query = new Query(Criteria.where("_id").is(id));
		List<ContactInfo>  listContactInfo = coreMongoTemplate.find(query, ContactInfo.class);
		if(listContactInfo.size() != 0 && listContactInfo != null){
			ci =  listContactInfo.get(0);
		}
		return ci;
	}



	public ShippingMethod getShippingMethodByShippingMethodId(String shippingMethodId) {
		ShippingMethod sm = null;
		Query query = new Query(Criteria.where("shippingMethodId").is(shippingMethodId));	
		List<ShippingMethod> listShippingMethods = coreMongoTemplate.find(query, ShippingMethod.class);
		if(listShippingMethods.size() != 0 && listShippingMethods != null){
			sm =  listShippingMethods.get(0);
		}
		return sm;
	}
	
	public ShippingMethod getShippingMethodById(String id) {
		ShippingMethod sm = null;
		Query query = new Query(Criteria.where("shippingMethodId").is(id));	
		List<ShippingMethod> listShippingMethods = coreMongoTemplate.find(query, ShippingMethod.class);
		if(listShippingMethods.size() != 0 && listShippingMethods != null){
			sm =  listShippingMethods.get(0);
		}
		return sm;
	}
	public String  createShippingGroup(ShippingGroup shippingGrp) {
		
		 coreMongoTemplate.save(shippingGrp);
		 return shippingGrp.getId();
	}
	
}

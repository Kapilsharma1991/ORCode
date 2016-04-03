/**
 * 
 */
package com.png.myacc.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * @author Manish Arora
 *
 */
public class UserProfile {
	
	@Id
	private String id;
	
	private String emailId;
	private String password;
	private String phoneNum;
	private String firstName;
	private String lastName;
	private int securityStatus;
	private int accountStatus;
	private List<String> pastOrders;
	private List<String> shippingGroups;
	private List<String> paymentGroups;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the securityStatus
	 */
	public int getSecurityStatus() {
		return securityStatus;
	}
	/**
	 * @param securityStatus the securityStatus to set
	 */
	public void setSecurityStatus(int securityStatus) {
		this.securityStatus = securityStatus;
	}
	/**
	 * @return the accountStatus
	 */
	public int getAccountStatus() {
		return accountStatus;
	}
	/**
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}
	/**
	 * @return the pastOrders
	 */
	public List<String> getPastOrders() {
		return pastOrders;
	}
	/**
	 * @param pastOrders the pastOrders to set
	 */
	public void setPastOrders(List<String> pastOrders) {
		this.pastOrders = pastOrders;
	}
	/**
	 * @return the shippingGroups
	 */
	public List<String> getShippingGroups() {
		return shippingGroups;
	}
	/**
	 * @param shippingGroups the shippingGroups to set
	 */
	public void setShippingGroups(List<String> shippingGroups) {
		this.shippingGroups = shippingGroups;
	}
	/**
	 * @return the paymentGroups
	 */
	public List<String> getPaymentGroups() {
		return paymentGroups;
	}
	/**
	 * @param paymentGroups the paymentGroups to set
	 */
	public void setPaymentGroups(List<String> paymentGroups) {
		this.paymentGroups = paymentGroups;
	}

}



/**
 * 
 */
package com.png.base;

/**
 * @author Manish Arora
 *
 */
public class BaseResponseVO {
	
	private Output output;
	private ErrorMap errorMap;
	private String serviceCode;
	private String serviceMessage;
	public Output getOutput() {
		return output;
	}
	public void setOutput(Output output) {
		this.output = output;
	}
	public ErrorMap getErrorMap() {
		return errorMap;
	}
	public void setErrorMap(ErrorMap errorMap) {
		this.errorMap = errorMap;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceMessage() {
		return serviceMessage;
	}
	public void setServiceMessage(String serviceMessage) {
		this.serviceMessage = serviceMessage;
	}

	
}



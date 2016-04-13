/**
 * 
 */
package com.png.sample;

import com.png.framework.security.AesUtil;

/**
 * @author Manish Arora
 *
 */


public class TestEncryption {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	// TODO Auto-generated method stub
		AesUtil util = new AesUtil(128, 100);
		String encrypt = util.encrypt(getSalt("965973469156146016"), "F27D5C9927726BCEFE7510B1BDD3D137", "aesalgoisbestbes",
				"pwd1234");
		System.out.println("encrypt:::"+encrypt);
		
		String decrypt = util.decrypt(getSalt("965973469156146016"), "F27D5C9927726BCEFE7510B1BDD3D137", "aesalgoisbestbes",
				encrypt);
		
		System.out.println("decrypt:::"+decrypt);*/
	}

	
	private static String getSalt(String sessionConfirmationNumber) {
		StringBuffer half1SALT = null, half2SALT = null;
		if (1 == sessionConfirmationNumber.length() % 2) {
			half1SALT = new StringBuffer(sessionConfirmationNumber.substring(1,
					(sessionConfirmationNumber.length() + 1) / 2));
			half2SALT = new StringBuffer(sessionConfirmationNumber.substring(
					(sessionConfirmationNumber.length() + 1) / 2,
					sessionConfirmationNumber.length()));
		} else {
			half1SALT = new StringBuffer(sessionConfirmationNumber.substring(1,
					sessionConfirmationNumber.length() / 2));
			half2SALT = new StringBuffer(sessionConfirmationNumber.substring(
					(sessionConfirmationNumber.length() + 1) / 2,
					sessionConfirmationNumber.length()));
		}
		while (half1SALT.length() < 32) {
			half1SALT.append("0");
		}
		while (half2SALT.length() < 32) {
			half2SALT.append("0");
		}
		String salt = (half1SALT.reverse().append(half2SALT.reverse())).toString();
		return salt;
	}
}



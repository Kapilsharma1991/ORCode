/**
 * 
 */
package com.png.sample;

/**
 * @author Manish Arora
 *
 */
public class TestParentChild {
	
	public static void main (String args[]) {
		Product prd = new Product();
		prd.setColor("black");
		prd.setId(1);
		prd.setName("iphone");
		prd.setPrice(100);
		
		Phone ph = (Phone) prd;
		ph.setCapacity("16gb");
		
		System.out.println(ph.getName()+" " +ph.getCapacity());
	}

}



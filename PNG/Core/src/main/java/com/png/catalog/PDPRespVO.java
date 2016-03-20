/**
 * 
 */
package com.png.catalog;

import java.util.List;

import com.png.catalog.Entity.Product;
import com.png.catalog.Entity.Sku;


/**
 * @author Manish Arora
 *
 */
public class PDPRespVO {
	
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Sku> getSkus() {
		return skus;
	}
	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}
	private List<Sku> skus;

}



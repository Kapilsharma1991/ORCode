package com.png.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MongoMains {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"DBBeans.xml");

		try {

			CoreMongoTools coreTools = (CoreMongoTools) context.getBean("coreMongoTools");
			
			
			ProductDetail prd = initializeProduct();
		
			String prodId = coreTools.createProduct(prd);

			ProductDetail dbProduct = coreTools.getProduct(prodId);
			System.out.println(dbProduct.toString());
			

		} catch (Exception e) {

		} finally {

			if (context != null) {
				{
					((AbstractApplicationContext) context).close();
				}
			}

		}
	}

	private static ProductDetail initializeProduct() {
		
		ProductDetail prd = new ProductDetail();
		prd.setName("Sony PLaystation 4");
		prd.setDescription("PlayStation 4 Ultimate player 1 TB Edition bundled with 2 free games - God of War Remastered and The Last of Us Remastered");
		prd.setColor("Black");
		prd.setPrice("RS 40000");
		return prd;
	}

}

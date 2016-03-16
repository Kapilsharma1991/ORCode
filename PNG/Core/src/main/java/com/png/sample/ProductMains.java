package com.png.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMains {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"DBBeans.xml");

		try {

			CatalogTools tools = (CatalogTools) context.getBean("catalogTools");
			tools.createProduct("Iphone", "White", 800);

			Product prd = tools.getProduct(1);
			System.out.println(prd.getName() + " " + prd.getColor()
					+ " Color's Price is $" + prd.getPrice());

		} catch (Exception e) {

		} finally {

			if (context != null) {
				{
					((AbstractApplicationContext) context).close();
				}
			}

		}
	}

}

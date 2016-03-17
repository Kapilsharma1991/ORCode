package com.png;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.png.sample.SampleTools;
import com.png.sample.Product;



@Controller
@RequestMapping ("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String handleHello (ModelMap model) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"DBBeans.xml");

		try {

			SampleTools tools = (SampleTools) context.getBean("catalogTools");
			tools.createProduct("Iphone", "RED", 800);

			Product prd = tools.getProduct(1);
			System.out.println(prd.getName() + " " + prd.getColor()
					+ " Color's Price is $" + prd.getPrice());

			model.addAttribute("message", "Hello there !!");
			model.addAttribute("product", prd.getName());
			
			
		} catch (Exception e) {

		} finally {

			if (context != null) {
				{
					((AbstractApplicationContext) context).close();
				}
			}

		}
		
		return "hello";
	}
		

}

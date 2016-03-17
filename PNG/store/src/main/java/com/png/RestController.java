package com.png;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.png.sample.SampleTools;
import com.png.sample.Product;




@org.springframework.web.bind.annotation.RestController
@EnableWebMvc

@RequestMapping (value="/pdp", headers="Accept=*/*",  produces="application/json")
public class RestController {

	
	@RequestMapping(method = RequestMethod.GET)
	public Product getPDPContent (HttpServletRequest request) {
		
		//request.get
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"DBBeans.xml");
		
		Product prd = new Product();

		try {

			SampleTools tools = (SampleTools) context.getBean("catalogTools");
			//tools.createProduct("Iphone", "RED", 800);

			prd = tools.getProduct(1);
		

		} catch (Exception e) {

		} finally {

			if (context != null) {
				{
					((AbstractApplicationContext) context).close();
				}
			}

		}
		
		return prd;
	}
		
	@RequestMapping (value="/thread/" , method = RequestMethod.GET)
	public void thread() {

		startMainThread();
		
		Thread t = new Thread() {
			
			public void run() {
			
				
				try {
					System.out.println("inside run before sleep");
					sleep(5000);
					System.out.println(getName());
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
			
		};
		
		t.start();
		
		endMainThread();
	}



	private void startMainThread() {
		
		System.out.println("inside startMainThread");
		System.out.println(Thread.currentThread().getName());	
		
	}
	
	private void endMainThread() {
		
		System.out.println("inside endMainThread");
		System.out.println(Thread.currentThread().getName());	
		
	}
}

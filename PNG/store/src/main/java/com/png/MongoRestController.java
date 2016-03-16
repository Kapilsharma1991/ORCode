package com.png;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.png.sample.CoreMongoTools;
import com.png.sample.ProductDetail;

@org.springframework.web.bind.annotation.RestController
@EnableWebMvc
@ResponseBody
@RequestMapping(value = "/product", headers = "Accept=*/*", produces = "application/json")
public class MongoRestController {
	
	private CoreMongoTools coreTools;

	@RequestMapping(method = RequestMethod.GET)
	public ProductDetail getPDPContent() {

		/*ApplicationContext context = new ClassPathXmlApplicationContext(
				"DBBeans.xml");

		ProductDetail dbProduct = null;

		try {

			CoreMongoTools coreTools = (CoreMongoTools) context
					.getBean("coreMongoTools");

			ProductDetail prd = initializeProduct();
			String prodId = coreTools.createProduct(prd);

			dbProduct = coreTools.getProduct(prodId);

		} catch (Exception e) {	

		} finally {

			if (context != null) {
				{
					((AbstractApplicationContext) context).close();
				}
			}

		}

		return dbProduct;*/
		
		
		

		ProductDetail dbProduct = null;

			ProductDetail prd = initializeProduct();
			String prodId = coreTools.createProduct(prd);

			dbProduct = coreTools.getProduct(prodId);


		return dbProduct;
	}

	private ProductDetail initializeProduct() {

		ProductDetail prd = new ProductDetail();
		prd.setName("Sony PLaystation 4");
		prd.setDescription("PlayStation 4 Ultimate player 1 TB Edition bundled with 2 free games - God of War Remastered and The Last of Us Remastered");
		prd.setColor("Black");
		prd.setPrice("RS 40000");
		return prd;
	}

	public CoreMongoTools getCoreTools() {
		return coreTools;
	}

	public void setCoreTools(CoreMongoTools coreTools) {
		this.coreTools = coreTools;
	}

}

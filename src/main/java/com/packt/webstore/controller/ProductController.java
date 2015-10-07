package com.packt.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;
@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	//private ProductRepository productRepository;
	  private ProductService productService;
  /*	@RequestMapping( value="/products",method=RequestMethod.GET)
	public String list(Model model){
		Product iphone = new Product("P1234","iPhone 5s", new
				BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(10000);
		model.addAttribute("product",iphone);
		
		return "products";
	}
	*/
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
	binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	@RequestMapping()
    public String getList(Product product, Model model){
		model.addAttribute("products", productService.getAllproduct());
		return "products";
	}
	
	@RequestMapping(value="/{category}", method=RequestMethod.GET)
	public String getBycategory(Model model,@PathVariable("category") String productCategory ){	
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public String getProductById(@RequestParam("id")String productID, Model model){
		model.addAttribute("product",productService.getproductByid(productID));
		return "product";
	}
	@RequestMapping(value="/filter/{ByCriteria}")
	public String getByCritrea(@MatrixVariable(pathVar="ByCriteria") Map<String, List<String>> filterParams,Model model){
		model.addAttribute("products" , productService.getProductsByFilter(filterParams));
		return "products";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getProduct(Product newProduct , Model model){
		model.addAttribute("newProduct" ,newProduct);
		return "addproduct";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
		public String processproduct(@ModelAttribute("Product")Product newProduct, BindingResult result){
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
		throw new RuntimeException("Attempting to binddisallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		productService.addProduct(newProduct);
		return"redirect:/products";
	}
}

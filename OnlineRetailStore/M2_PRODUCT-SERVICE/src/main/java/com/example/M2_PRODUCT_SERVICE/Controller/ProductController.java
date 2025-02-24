package com.example.M2_PRODUCT_SERVICE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.M2_PRODUCT_SERVICE.DTO.ProductRequest;
import com.example.M2_PRODUCT_SERVICE.Entity.Product;
import com.example.M2_PRODUCT_SERVICE.Service.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/post")
	public String create(@RequestBody ProductRequest product) {
		 productService.create(product);
		 return "product created";
	}
	
	@GetMapping("/get/{productid}")
	public Product get(@PathVariable Long productid ) {
		return productService.get(productid);
	}
	
	/*
	 * @PostMapping("/post/{productname}") public String
	 * getproductbyname(@PathVariable String productname) { return
	 * productService.getproductbyname(productname); }
	 */
	
	
}

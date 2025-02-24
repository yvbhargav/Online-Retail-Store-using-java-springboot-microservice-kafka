package com.example.M2_PRODUCT_SERVICE.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.M2_PRODUCT_SERVICE.DTO.Inventry;
import com.example.M2_PRODUCT_SERVICE.DTO.ProductRequest;
import com.example.M2_PRODUCT_SERVICE.Entity.Product;
import com.example.M2_PRODUCT_SERVICE.Externalclient.InventryService;
import com.example.M2_PRODUCT_SERVICE.Repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private InventryService inventryService;
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public String create(ProductRequest product) {
	    log.info("Product received from cart service");

	    // Check if the product already exists
		
		  if (productRepository.existsById(product.getProductid())) {
		  log.info("Product already exists, skipping creation.");
		  return "Product already exists"; }
		 
	    // Create and save new product
	    Product p = new Product();
	    p.setPrice(product.getPrice());
	  //  p.setProductid(product.getProductid());
	    p.setProductname(product.getProductname());
	    p.setProductdescription(product.getProductdescription());

	    Product productdb = productRepository.save(p);
	    log.info("Product created successfully.");
	 // Create inventory entry
	    Inventry inventry = new Inventry();
	    inventry.setProductid(productdb.getProductid());
	    inventry.setQuantity(product.getQuantity());
	    inventryService.create(inventry);
	    
	    log.info("created products sent to inventry via feign client");
	   
	    
	    return "Product created";
	}


	public Product get(Long productid) {
		Product product = productRepository.findById(productid).orElseThrow(()-> new RuntimeException("product with id not found"));
		return product;
	}
	public String getproductbyname(String productname) {
		Product product = productRepository.findByProductname(productname);
		return "product found with product name: "+productname+" "+product;
	}

}

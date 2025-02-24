package com.example.M2_CART_SERVICE.External.Feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.M2_CART_SERVICE.Entity.ProductRequest;
import com.example.M2_CART_SERVICE.External.Class.Product;

@FeignClient(name="M2PRODUCT-SERVICE")
public interface ProductService {

	@PostMapping("/Product/post")
	public String create(@RequestBody ProductRequest product); 
}

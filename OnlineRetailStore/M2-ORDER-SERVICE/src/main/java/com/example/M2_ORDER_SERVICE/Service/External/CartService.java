package com.example.M2_ORDER_SERVICE.Service.External;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.M2_ORDER_SERVICE.Service.ExternalClass.Cart;


@FeignClient(name="M2-CART-SERVICE")
public interface CartService {

	
	@GetMapping("Cart/get/{cartid}")
	public Cart getbyid(@PathVariable Long cartid );
	
	@PutMapping("Cart/nullthecart/{cartid}")
	void nullthecart(@PathVariable("cartid") Long cartid, @RequestBody Cart cart);
	
	@DeleteMapping("Cart/delete")
	public void delete();
}

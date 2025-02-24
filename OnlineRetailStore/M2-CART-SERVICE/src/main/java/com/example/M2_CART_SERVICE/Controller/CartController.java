package com.example.M2_CART_SERVICE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.M2_CART_SERVICE.Entity.Cart;
import com.example.M2_CART_SERVICE.Entity.Customer_Cart;
import com.example.M2_CART_SERVICE.Entity.Lineitem;
import com.example.M2_CART_SERVICE.Entity.LineitemDTO;
import com.example.M2_CART_SERVICE.Service.CartService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/Cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/post")
	public Cart createcart(@RequestBody Cart cart) {
		return cartService.createcart(cart);	
	}
	
	@PutMapping("/updatecart/{cartid}")
	public Cart updatecart(@PathVariable Long cartid,@RequestBody Cart cart) {
		return cartService.updatecart(cartid,cart);
	}
	

	@PostMapping("/post/lineitems/{customerid}")
	public String postlineitems(@PathVariable Long customerid,@RequestBody List<Lineitem> lineitem) {
		return cartService.postlineitems(customerid,lineitem);
	}
	@GetMapping("/get/{customerid}")
	public Cart getbyid(@PathVariable Long customerid ) {
		return cartService.getbyid(customerid);
	}
	
	@PutMapping("/nullthecart/{cartid}")
	public void nullthecart(@PathVariable Long cartid) {
	   
	         cartService.nullthecart(cartid);
		}
	
	@DeleteMapping("/delete")
	public void delete() {
		cartService.delete();
	}
	
}






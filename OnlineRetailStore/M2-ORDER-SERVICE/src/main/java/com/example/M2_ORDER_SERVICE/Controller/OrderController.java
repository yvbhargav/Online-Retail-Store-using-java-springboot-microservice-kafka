package com.example.M2_ORDER_SERVICE.Controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.M2_ORDER_SERVICE.Entity.Order;
import com.example.M2_ORDER_SERVICE.Service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/create/orders/{customerid}")
	public CompletableFuture<String> getbycustomerids(@PathVariable Long customerid) {
		return orderService.getbycustomerids(customerid);
	}
	@GetMapping("/get/{orderid}")
	public Order getbyorderid(@PathVariable Long orderid) {
		Order o=orderService.getbyorderid(orderid);
		String s="bhargav+venkata";
        return o;
	}
	
	
}

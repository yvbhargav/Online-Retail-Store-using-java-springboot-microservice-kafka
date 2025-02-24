package com.example.M2_CUSTOMER_SERVICE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.M2_CUSTOMER_SERVICE.Entity.CustomerAddress;
import com.example.M2_CUSTOMER_SERVICE.Service.CustomerAddressService;

@RestController
@RequestMapping("/CustomerAddress")
public class CustomerAddressController {

	@Autowired
	private CustomerAddressService customeraddressService;
	@GetMapping("/get/{customeraddressid}")
	public CustomerAddress get(@PathVariable Long customeraddressid) {
		return customeraddressService.get(customeraddressid);
	}
}

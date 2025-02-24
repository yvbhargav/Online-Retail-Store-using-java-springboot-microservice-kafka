package com.example.M2_CUSTOMER_SERVICE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.example.M2_CUSTOMER_SERVICE.DTO.CustomerRequest;
import com.example.M2_CUSTOMER_SERVICE.Entity.Customer;
import com.example.M2_CUSTOMER_SERVICE.Service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/post")
	public ResponseEntity<Customer> createcustomer(@RequestBody CustomerRequest customerrequest) {
		return  ResponseEntity.status(HttpStatus.OK).body(customerService.createcustomer(customerrequest));
	}
	@GetMapping("/get/{customerid}")
	public Customer get(@PathVariable Long customerid ) {
		return customerService.get(customerid);
	}
}

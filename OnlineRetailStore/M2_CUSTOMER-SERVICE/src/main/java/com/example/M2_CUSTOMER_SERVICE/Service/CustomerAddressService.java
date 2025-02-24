package com.example.M2_CUSTOMER_SERVICE.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.M2_CUSTOMER_SERVICE.Entity.CustomerAddress;
import com.example.M2_CUSTOMER_SERVICE.Repository.CustomerAddressRepository;

@Service
public class CustomerAddressService {

	@Autowired
	private CustomerAddressRepository customeraddressRepository;
	public CustomerAddress get(Long customeraddressid) {
		CustomerAddress ca = customeraddressRepository.findById(customeraddressid).orElseThrow(()-> new RuntimeException("customeraddress not found"));
		return ca;
	}

}

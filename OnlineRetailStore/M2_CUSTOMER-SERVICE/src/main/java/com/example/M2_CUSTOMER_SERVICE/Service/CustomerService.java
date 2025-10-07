package com.example.M2_CUSTOMER_SERVICE.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.M2_CUSTOMER_SERVICE.DTO.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.M2_CUSTOMER_SERVICE.Entity.Customer;
import com.example.M2_CUSTOMER_SERVICE.Entity.CustomerAddress;
import com.example.M2_CUSTOMER_SERVICE.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Value("${kafka.topic.name}")
	private String topicname;
	
	 @Autowired
	    private KafkaTemplate<String, Object> kafkaTemplate;
	 
	 @Transactional
	public Customer createcustomer(CustomerRequest customerrequest) {
		Customer customer = new Customer();
		customer.setCustomername(customerrequest.getCustomername());
		customer.setCustomeremail(customerrequest.getCustomeremail());
		customer.setCustomerbillingaddress(customerrequest.getCustomerbillingaddress());
		customer.setCustomershippingaddress(customerrequest.getCustomershippingaddress());
		customer.setCustomerid(customerrequest.getCustomerid());
		
		List<CustomerAddress>calist= customerrequest.getCustomeraddresslist();
		List<CustomerAddress>calistdb = new ArrayList<CustomerAddress>();
		
		for(CustomerAddress ca : calist) {
			CustomerAddress car = new CustomerAddress();
			
			car.setCity(ca.getCity());
			car.setDoorno(ca.getDoorno());
			car.setStreetname(ca.getStreetname());
			car.setPincode(ca.getPincode());
			car.setCustomeraddressid(ca.getCustomeraddressid());
			car.setCustomer(customer);
			calistdb.add(car);
		}
		customer.setCustomeraddresslist(calistdb);
		Customer c= customerRepository.save(customer);
		kafkaTemplate.send(topicname,String.valueOf(c.getCustomerid()));
		return c;
	}
	public Customer get(Long customerid) {
		Customer customer = customerRepository.findById(customerid).orElseThrow(()-> new RuntimeException("customer not found"));
		Customer dbcustomer=customer;
		return customer;
	}

}

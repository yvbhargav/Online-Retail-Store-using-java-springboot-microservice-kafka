package com.example.M2_CUSTOMER_SERVICE.DTO;

import java.util.List;

import com.example.M2_CUSTOMER_SERVICE.Entity.CustomerAddress;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

	private Long customerid;
	private String customername;
	private String customeremail;
	private String customerbillingaddress;
	private String customershippingaddress;
	private List<CustomerAddress>customeraddresslist;
}

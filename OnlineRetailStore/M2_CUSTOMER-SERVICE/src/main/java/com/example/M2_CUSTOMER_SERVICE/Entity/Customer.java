package com.example.M2_CUSTOMER_SERVICE.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq_gen")
    @SequenceGenerator(name = "my_seq_gen", sequenceName = "my_sequence", initialValue = 100, allocationSize = 1)
	private Long customerid;
	private String customername;
	private String customeremail;
	private String customerbillingaddress;
	private String customershippingaddress;
	
	@JsonIgnoreProperties(value="customer")
	@OneToMany(mappedBy ="customer" ,cascade=CascadeType.ALL)
	private List<CustomerAddress>customeraddresslist;
}

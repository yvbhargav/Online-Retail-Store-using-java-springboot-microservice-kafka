package com.example.M2_CUSTOMER_SERVICE.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress {

	@Id
	private Long customeraddressid;
	private Long doorno;
	private String streetname;
	private String city;
	private Long pincode;
	
	@JsonIgnoreProperties(value="customeraddresslist")
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerid")
	private Customer customer;
}

package com.example.M2_INVENTRY_SERVICE.Externalclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lineitem {

	
	private Long itemid;   //m2-cart-db
	private Long productid;//m2_customer_db
	private String productname;
	private Long Quantity;
	private Long price;
	
	
}

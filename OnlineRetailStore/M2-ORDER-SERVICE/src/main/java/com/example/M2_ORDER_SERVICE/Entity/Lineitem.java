package com.example.M2_ORDER_SERVICE.Entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lineitem {

	@Id
	private Long itemid;
	private Long productid;
	private String productname;
	private String Quantity;
	private Long price;
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name= "orderid")
	@JsonIgnoreProperties(value="lineitems")
	private Order order;
}
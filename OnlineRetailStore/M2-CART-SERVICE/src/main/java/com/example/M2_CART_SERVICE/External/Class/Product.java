package com.example.M2_CART_SERVICE.External.Class;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Long productid;
	private String productname;
	private String productdescription;
	private Long price;
	private Long quantity;
	
}

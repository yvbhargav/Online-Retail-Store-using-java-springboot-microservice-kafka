package com.example.M2_PRODUCT_SERVICE.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productid;
	private String productname;
	private String productdescription;
	private Long price;
	
}

/*
 * {

    "productname":"SAMSUNG-24-ULTRA",
    "productdescription":"GREAT CHOICE IN ANDROID PHONES",
    "price":72000
}
 */






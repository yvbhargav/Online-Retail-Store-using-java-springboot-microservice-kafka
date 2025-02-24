package com.example.M2_INVENTRY_SERVICE.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventryRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventryid;
	private Long productid;
	private String productname;
	private String productdescription;
	private Long price;
	private Long quantity;

}

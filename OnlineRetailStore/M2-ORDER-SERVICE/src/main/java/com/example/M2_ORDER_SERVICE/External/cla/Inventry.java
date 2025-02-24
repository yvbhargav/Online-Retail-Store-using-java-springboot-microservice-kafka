package com.example.M2_ORDER_SERVICE.External.cla;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventry {
	private Long inventryid;
	private Long productid;
	private Long quantity;
}

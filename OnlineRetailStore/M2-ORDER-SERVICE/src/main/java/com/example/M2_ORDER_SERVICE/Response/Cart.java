package com.example.M2_ORDER_SERVICE.Response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	
	private Long cartid;
	
	private List<Lineitem> lineitems;
	
}

package com.example.M2_ORDER_SERVICE.Service.ExternalClass;

import java.util.List;

import com.example.M2_ORDER_SERVICE.Entity.Lineitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	private Long cartid;
	private List<Lineitem> lineitems;

}

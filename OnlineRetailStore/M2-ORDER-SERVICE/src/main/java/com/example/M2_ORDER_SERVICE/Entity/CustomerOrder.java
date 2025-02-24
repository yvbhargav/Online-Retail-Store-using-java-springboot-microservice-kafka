package com.example.M2_ORDER_SERVICE.Entity;

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
public class CustomerOrder {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or GenerationType.AUTO
	private Long id;
	private Long orderid;
	private Long customerid;
}

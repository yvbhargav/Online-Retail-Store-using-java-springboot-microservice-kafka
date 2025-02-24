package com.example.M2_INVENTRY_SERVICE.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventryid;
	private Long productid;
	private Long quantity;
	
}

package com.example.M2_CART_SERVICE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.M2_CART_SERVICE.Entity.Customer_Cart;

@Repository
public interface Customer_CartRepository extends JpaRepository<Customer_Cart,Long> {

	Customer_Cart findByCustomerid(Long customerid) ;
		
	
}

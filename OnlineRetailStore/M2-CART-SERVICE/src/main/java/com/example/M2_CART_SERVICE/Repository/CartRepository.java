package com.example.M2_CART_SERVICE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.M2_CART_SERVICE.Entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}

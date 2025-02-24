package com.example.M2_CART_SERVICE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.M2_CART_SERVICE.Entity.Cart;
import com.example.M2_CART_SERVICE.Entity.Lineitem;

@Repository
public interface LineitemRepository extends JpaRepository<Lineitem, Long> {

	void deleteByItemid (Long itemid);
}

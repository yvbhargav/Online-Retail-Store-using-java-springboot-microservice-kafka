package com.example.M2_PRODUCT_SERVICE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.M2_PRODUCT_SERVICE.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductname(String productname);
}

package com.example.M2_ORDER_SERVICE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.M2_ORDER_SERVICE.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

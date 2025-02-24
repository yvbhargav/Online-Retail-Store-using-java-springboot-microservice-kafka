package com.example.M2_CUSTOMER_SERVICE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.M2_CUSTOMER_SERVICE.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}

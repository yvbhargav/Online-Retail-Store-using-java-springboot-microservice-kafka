package com.example.M2_INVENTRY_SERVICE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.M2_INVENTRY_SERVICE.Entity.Inventry;

@Repository
public interface InventryRepository extends JpaRepository<Inventry, Long> {

	Inventry findByProductid(Long productid);
}

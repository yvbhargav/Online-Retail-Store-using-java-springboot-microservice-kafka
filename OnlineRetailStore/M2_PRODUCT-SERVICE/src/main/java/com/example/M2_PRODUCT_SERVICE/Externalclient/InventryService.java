package com.example.M2_PRODUCT_SERVICE.Externalclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.M2_PRODUCT_SERVICE.DTO.Inventry;


@FeignClient(name="M2INVENTRY-SERVICE/Inventry")
public interface InventryService {
	@PostMapping("/post")
	public Inventry create(@RequestBody Inventry inventryrequest) ;
}

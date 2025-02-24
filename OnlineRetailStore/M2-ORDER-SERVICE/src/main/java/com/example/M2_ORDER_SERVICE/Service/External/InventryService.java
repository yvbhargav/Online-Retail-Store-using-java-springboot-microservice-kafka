package com.example.M2_ORDER_SERVICE.Service.External;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.M2_ORDER_SERVICE.External.cla.Inventry;
import com.example.M2_ORDER_SERVICE.Service.ExternalClass.UpdateQuantityRequest;





@FeignClient(name="M2INVENTRY-SERVICE")
public interface InventryService {

	@PutMapping("/Inventry/put/byproduct/put/{productid}")
	public Inventry putid(@PathVariable Long productid,@RequestBody  UpdateQuantityRequest quantity);
}

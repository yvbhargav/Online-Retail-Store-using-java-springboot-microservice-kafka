package com.example.M2_INVENTRY_SERVICE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.M2_INVENTRY_SERVICE.DTO.InventryRequest;
import com.example.M2_INVENTRY_SERVICE.Entity.Inventry;
import com.example.M2_INVENTRY_SERVICE.Entity.UpdateQuantityRequest;
import com.example.M2_INVENTRY_SERVICE.Service.InventryService;

@RestController
@RequestMapping("/Inventry")
public class InventryController {

	
	@Autowired
	private InventryService inventryService;
	
	@PostMapping("/post")
	public Inventry create(@RequestBody Inventry inventryrequest) {
		return inventryService.create(inventryrequest);
	}
	
	@GetMapping("/get/{productid}/byproduct")
	public Inventry getiid(@PathVariable Long productid) {
		return inventryService.getiid(productid);
	}
	
	@PutMapping("/put/byproduct/put/{productid}")
	public Inventry putid(@PathVariable Long productid,@RequestBody  UpdateQuantityRequest quantity) {
		return inventryService.putid(productid,quantity);
	}
	
	@GetMapping("/get/{inventryid}")
	public Inventry get(@PathVariable Long inventryid) {
		return inventryService.get(inventryid);
	}
	
	@PutMapping("/put")
	public Inventry putm(@RequestBody Inventry inventryrequest, @RequestParam Long inventryid) {
		return inventryService.putm(inventryrequest,inventryid);
	}
	
	@PutMapping("/updatequantity/{productid}")
    String putproduct(@PathVariable("productid") Long productid, @RequestParam Long quantity) {
		 inventryService.putproduct(productid,quantity);
		 return "Quantity updated for the productid "+productid;
	}
	
	
}

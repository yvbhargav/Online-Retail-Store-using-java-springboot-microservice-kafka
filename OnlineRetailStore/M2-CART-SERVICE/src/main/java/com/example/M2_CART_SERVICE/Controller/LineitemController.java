package com.example.M2_CART_SERVICE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.M2_CART_SERVICE.Entity.Lineitem;
import com.example.M2_CART_SERVICE.Service.LineitemService;

@RestController
@RequestMapping("/Lineitem")
public class LineitemController {

	@Autowired
	private LineitemService lineitemService;
	@GetMapping("/get/{itemid}")
	public Lineitem getbyid(@PathVariable Long itemid) {
		return lineitemService.getbyid(itemid);
	}
	
	@DeleteMapping("/del/{itemid}")
	public void delete(@PathVariable Long itemid) {
		 lineitemService.delete(itemid);
	}
	
}

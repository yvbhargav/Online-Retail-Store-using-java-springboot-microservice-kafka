package com.example.M2_INVENTRY_SERVICE.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.M2_INVENTRY_SERVICE.DTO.InventryRequest;
import com.example.M2_INVENTRY_SERVICE.Entity.Inventry;
import com.example.M2_INVENTRY_SERVICE.Entity.UpdateQuantityRequest;
import com.example.M2_INVENTRY_SERVICE.Repository.InventryRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class InventryService {

	
	@Autowired
	private InventryRepository inventryRepository;
	public Inventry create(Inventry inventryrequest) {
		log.info("inventry created");
		Inventry i = new Inventry();
		i.setInventryid(inventryrequest.getInventryid());
		i.setProductid(inventryrequest.getProductid());
		i.setQuantity(inventryrequest.getQuantity());
		return inventryRepository.save(i);
	}
	public Inventry get(Long inventryid) {
		Inventry i = inventryRepository.findById(inventryid).orElseThrow(()-> new RuntimeException("inventry not found with id"));
		return i;
	}
	public Inventry putm(Inventry inventryrequest,Long inventryid) {
		Inventry i = inventryRepository.findById(inventryid).orElseThrow(()-> new RuntimeException("inventry not found with id"));
	//	i.setInventryid(inventryrequest.getInventryid());
		i.setProductid(inventryrequest.getProductid());
		i.setQuantity(inventryrequest.getQuantity());
		return inventryRepository.save(i);
	}
	public Inventry putproduct(Long productid,Long quantity) {
		Inventry i=inventryRepository.findByProductid(productid);
		Long q;
		
		i.setQuantity(i.getQuantity()+quantity);
		Inventry idb=inventryRepository.save(i);
		log.info("update quantity in inventry for a product id"+i.getProductid());
		
		return idb;
	}
	public Inventry getiid(Long productid) {
		Inventry i = inventryRepository.findByProductid(productid);
		return i;
	}
	public Inventry putid(Long productid, UpdateQuantityRequest quantity) {
		Inventry i = inventryRepository.findByProductid(productid);
		i.setQuantity(i.getQuantity()-quantity.getQuantity());
		inventryRepository.save(i);
		return i;
	}

}

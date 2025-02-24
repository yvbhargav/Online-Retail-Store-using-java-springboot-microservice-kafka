package com.example.M2_CART_SERVICE.Service;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import com.example.M2_CART_SERVICE.Entity.Lineitem;
import com.example.M2_CART_SERVICE.Repository.LineitemRepository;

@Service
public class LineitemService {

	@Autowired
	private LineitemRepository lineitemRepository;
	public Lineitem getbyid(Long itemid) {
		
		Lineitem li= lineitemRepository.findById(itemid).orElseThrow(()-> new RuntimeException("lineitem not found with itemid"));
		
		return li;
	}
	public void delete(Long itemid) {
		
		Lineitem li= lineitemRepository.findById(itemid).orElseThrow(()-> new RuntimeException("lineitem not found with itemid"));
		if(li.getCart().equals(null)) {
			lineitemRepository.deleteById(itemid);
		}
		lineitemRepository.save(li);
	}

	
}

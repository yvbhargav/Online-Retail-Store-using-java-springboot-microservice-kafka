package com.example.M2_ORDER_SERVICE.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.M2_ORDER_SERVICE.Entity.CustomerOrder;
import com.example.M2_ORDER_SERVICE.Entity.Lineitem;
import com.example.M2_ORDER_SERVICE.Entity.Order;
import com.example.M2_ORDER_SERVICE.External.cla.Inventry;
import com.example.M2_ORDER_SERVICE.Repository.CustomerOrderRepository;
import com.example.M2_ORDER_SERVICE.Repository.LineitemRepository;
import com.example.M2_ORDER_SERVICE.Repository.OrderRepository;
import com.example.M2_ORDER_SERVICE.Service.External.CartService;
import com.example.M2_ORDER_SERVICE.Service.External.InventryService;
import com.example.M2_ORDER_SERVICE.Service.ExternalClass.Cart;
import com.example.M2_ORDER_SERVICE.Service.ExternalClass.UpdateQuantityRequest;

import feign.FeignException.FeignClientException;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderService {
	
		
		  private final RestTemplate restTemplate;
		  
		  public OrderService(RestTemplate restTemplate) { 
			  this.restTemplate =restTemplate; 
			  }
		 
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private LineitemRepository lineitemRepository;
	
	@Autowired
	private CustomerOrderRepository customerorderRpository;

	@Autowired
	private InventryService inventryService;
	
	@Transactional
	@Async
	public CompletableFuture<String> getbycustomerids(Long customerid) {
	    return CompletableFuture.supplyAsync(() -> {
	        Cart c = cartService.getbyid(customerid);
	        Order order = new Order();
	        List<Lineitem> newlineitemlist = new ArrayList<>();

	        for (Lineitem li : c.getLineitems()) {
	            Lineitem l = new Lineitem();
	            l.setItemid(li.getItemid());
	            l.setOrder(order);
	            l.setPrice(li.getPrice());
	            l.setProductid(li.getProductid());
	            l.setProductname(li.getProductname());
	            l.setQuantity(li.getQuantity());
	            newlineitemlist.add(l);
	        }

	        order.setLineitems(newlineitemlist);
	        Order dborder = orderRepository.save(order);

	        CustomerOrder co = new CustomerOrder();
	        co.setCustomerid(customerid);
	        co.setOrderid(dborder.getOrderid());
	        customerorderRpository.save(co);

	        // Process Inventory Updates Asynchronously
	        dborder.getLineitems().forEach(l -> {
	            CompletableFuture.runAsync(() -> {
	                UpdateQuantityRequest request = new UpdateQuantityRequest();
	                request.setQuantity(Long.parseLong(l.getQuantity())); 
	                Long productid = l.getProductid();
	                log.info("Updating inventory: Quantity={} ProductID={}", request.getQuantity(), productid);
	                inventryService.putid(productid, request);
	            });
	        });

	        log.info("Inventory update requests sent via Feign Client.");

	        // Clear Cart Asynchronously
	        CompletableFuture.runAsync(() -> {
	            String url = "http://M2-CART-SERVICE/Cart/nullthecart/{cartId}";
	            restTemplate.put(url, null, c.getCartid());
	            cartService.delete();
	            log.info("Cart cleared successfully.");
	        });

	        return "Order successfully created for customer ID: " + customerid;
	    });
	}
	public Order getbyorderid(Long orderid) {

		Order order =orderRepository.findById(orderid).orElseThrow(()-> new RuntimeException("order not found by given order id"+orderid));
		return order;
	}

	
			
	
	
}


 



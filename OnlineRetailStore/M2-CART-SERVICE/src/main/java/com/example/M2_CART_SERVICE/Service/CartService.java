package com.example.M2_CART_SERVICE.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.backoff.FixedBackOff;

import com.example.M2_CART_SERVICE.Entity.Cart;
import com.example.M2_CART_SERVICE.Entity.Customer_Cart;
import com.example.M2_CART_SERVICE.Entity.Lineitem;
import com.example.M2_CART_SERVICE.Entity.LineitemDTO;
import com.example.M2_CART_SERVICE.Entity.ProductRequest;
import com.example.M2_CART_SERVICE.External.Class.Product;
import com.example.M2_CART_SERVICE.External.Feignclient.ProductService;
import com.example.M2_CART_SERVICE.Repository.CartRepository;
import com.example.M2_CART_SERVICE.Repository.Customer_CartRepository;
import com.example.M2_CART_SERVICE.Repository.LineitemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CartService {

	  
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private LineitemRepository lineitemRepository;
	
	@Autowired
	private Customer_CartRepository repository;
	
	
	@Autowired
	private ProductService productService;
	
	public  Cart createcart(Cart cartrequest) {
		Cart cart = new Cart();
		cart.setCartid(cartrequest.getCartid());
		List<Lineitem>lineitemslist = new ArrayList<Lineitem>();
		List<Lineitem>lineitemlistrequest = cartrequest.getLineitems();
		for(Lineitem li : lineitemlistrequest) {
			Lineitem dbli = new Lineitem();
			dbli.setItemid(li.getItemid());
			dbli.setPrice(li.getPrice());
			dbli.setProductid(li.getProductid());
			dbli.setProductname(li.getProductname());
			dbli.setQuantity(li.getQuantity());
			dbli.setCart(cart);
			lineitemslist.add(dbli);
		}
		cart.setLineitems(lineitemslist);
		Cart dbcart= cartRepository.save(cart);
		
		return dbcart;
	}

	public Cart updatecart(Long cartid, Cart cart) {
		Cart dbcart=cartRepository.findById(cartid).orElseThrow(()-> new RuntimeException("cart not found with cartid"+cartid));
		if(cart.getLineitems()!=null) {
			List<Lineitem>lineitemslist = new ArrayList<Lineitem>();
			List<Lineitem>lineitemlistrequest = cart.getLineitems();
			List<Lineitem>dblineitemlist=dbcart.getLineitems();
			if(dblineitemlist!=null) {
				for(Lineitem lir:lineitemlistrequest) {
					for(Lineitem li :dblineitemlist) {
						if(li.getItemid()==lir.getItemid()) {
							//Lineitem li = new Lineitem();
							li.setItemid(lir.getItemid());
							li.setPrice(lir.getPrice());
							li.setProductid(lir.getProductid());
							li.setProductname(lir.getProductname());
							li.setQuantity(lir.getQuantity());
							li.setCart(dbcart);
							lineitemslist.add(li);
						}
						else {
							Lineitem lin = new Lineitem();
							lin.setItemid(lir.getItemid());
							lin.setPrice(lir.getPrice());
							lin.setProductid(lir.getProductid());
							lin.setProductname(lir.getProductname());
							lin.setQuantity(lir.getQuantity());
							lin.setCart(dbcart);
							lineitemslist.add(li);
						}
							
					}
				}
			}
			dbcart.setCartid(cartid);
			dbcart.setLineitems(lineitemslist);
		}
		
		Cart c= cartRepository.save(dbcart);
		
		return c;
	}

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${group-id}")
	public void consumeCustomerEvent(String s) {
	
		Long i= Long.parseLong(s);

		Cart ccart = new Cart();
		cartRepository.save(ccart);
	    Customer_Cart customerCart = new Customer_Cart();
        customerCart.setCustomerid(i);
        customerCart.setCartid(ccart.getCartid());
       Customer_Cart cc= repository.save(customerCart);
	     log.info("cart created ");
		}
	

	
	@Transactional
	public String postlineitems(Long customerid,List<Lineitem> lineitem) {
		Customer_Cart cc = repository.findByCustomerid(customerid);
	    if (cc == null) {
	        throw new IllegalStateException("cart not found with customer id"+customerid);
	    }

	    Cart dbCart = cartRepository.findById(cc.getCartid())
	            .orElseThrow(() -> new RuntimeException("Cart not found with cartId: " + cc.getCartid()));

	    List<Lineitem> lilist = new ArrayList<Lineitem>();
	    
		for(Lineitem lir:lineitem) {
			Lineitem li = new Lineitem();
			li.setItemid(lir.getItemid());
			li.setPrice(lir.getPrice());
			li.setProductid(lir.getProductid());
			li.setProductname(lir.getProductname());
			li.setQuantity(lir.getQuantity());
			li.setCart(dbCart);
			lilist.add(li);
		}
		dbCart.setLineitems(lilist);
		cartRepository.save(dbCart);
		
		log.info("................cart was updated with new products..................");

		for(Lineitem li:dbCart.getLineitems()) {
			ProductRequest p = new ProductRequest();
			p.setProductdescription("Website Assured product");
			p.setProductid(li.getProductid());
			p.setProductname(li.getProductname());
			p.setPrice(li.getPrice());
			p.setQuantity(li.getQuantity());
		
			productService.create(p);
			log.info("product created in cart and moving to productservice");
		}
		return "created the lineitems for cart and product record created in productservice";
	}

	public  Cart getbyid(Long customerid) {
		Customer_Cart cc = repository.findByCustomerid(customerid);
		Cart dbCart = cartRepository.findById(cc.getCartid())
	            .orElseThrow(() -> new RuntimeException("Cart not found with cartId: " + customerid));

		return dbCart;
	}
	
    List<Long> itemlist = new ArrayList<Long>();

	@Transactional
	public void nullthecart(Long cartid) {
	   
		System.out.println("................................."+cartid);
		
		 Cart dbCart = cartRepository.findById(cartid)
		            .orElseThrow(() -> new RuntimeException("Cart not found with cartId: " + cartid));

		    List<Lineitem> lilist = new ArrayList<Lineitem>();
		    
			for(Lineitem lir:dbCart.getLineitems()) {
				Lineitem li = new Lineitem();
				li.setItemid(lir.getItemid());
				li.setPrice(lir.getPrice());
				li.setProductid(lir.getProductid());
				li.setProductname(lir.getProductname());
				li.setQuantity(lir.getQuantity());
				li.setCart(null);
				lilist.add(li);
				itemlist.add(li.getItemid());
			}
			dbCart.setLineitems(lilist);
			cartRepository.save(dbCart);
			
	}

	public void delete() {

		
			for(Long li: itemlist) {
				for(Lineitem l: lineitemRepository.findAll()) {
					if(li.equals(l.getItemid())) {
						lineitemRepository.deleteById(li);
				}
			}
		}
			
	}

	//itemlist=null;
			   			
	
}








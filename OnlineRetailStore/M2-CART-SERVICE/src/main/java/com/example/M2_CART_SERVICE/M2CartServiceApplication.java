package com.example.M2_CART_SERVICE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class M2CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(M2CartServiceApplication.class, args);
	}

}

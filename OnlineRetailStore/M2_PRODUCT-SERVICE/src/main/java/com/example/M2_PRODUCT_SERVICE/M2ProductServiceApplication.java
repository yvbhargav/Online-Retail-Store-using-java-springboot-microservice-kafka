package com.example.M2_PRODUCT_SERVICE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class M2ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(M2ProductServiceApplication.class, args);
	}

}

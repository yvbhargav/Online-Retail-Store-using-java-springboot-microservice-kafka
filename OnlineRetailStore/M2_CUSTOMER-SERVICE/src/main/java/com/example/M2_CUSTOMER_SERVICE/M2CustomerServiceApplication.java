package com.example.M2_CUSTOMER_SERVICE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class M2CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(M2CustomerServiceApplication.class, args);
	}

}
/*
{
"customername":"bhargav",
"customeremail":"yvbhargav11@gmail.com",
"customerbillingaddress":"hyderabad-gowlidody",
"customershippingaddress":"cumbum-gandhibazar",
"customeraddresslist":[
    
    {
        "customeraddressid":1,
        "doorno": 55,
        "streetname":"gowlidody",
        "city":"hyderabad",
        "pincode":500032
    },
    {
        "customeraddressid":2,
        "doorno": 55,
        "streetname":"gandhibazar",
        "city":"cumbum",
        "pincode":523333
    }
]
}

*/
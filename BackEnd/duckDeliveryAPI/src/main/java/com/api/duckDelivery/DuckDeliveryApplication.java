package com.api.duckDelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DuckDeliveryApplication {
	public static void main(String[] args) {
		SpringApplication.run(DuckDeliveryApplication.class, args);
	}
}
@RestController
class MyControler {
	@GetMapping("/")
	public String index() {
		return "OK";
	}
}
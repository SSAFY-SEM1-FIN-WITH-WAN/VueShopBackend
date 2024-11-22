package com.ssafy.commerce.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SellProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellProductApplication.class, args);
	}

}

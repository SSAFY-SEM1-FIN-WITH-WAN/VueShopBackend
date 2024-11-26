package com.ssafy.commerce.demo.healthcheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping("/health")
	public boolean healthCheck() {
		return true;
	}
}

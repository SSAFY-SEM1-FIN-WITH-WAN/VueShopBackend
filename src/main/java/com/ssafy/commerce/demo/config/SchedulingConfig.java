//package com.ssafy.commerce.demo.config;
//
//import java.io.IOException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.ssafy.commerce.demo.scrap.ScrappingService;
//
//import jakarta.annotation.PostConstruct;
//
//@Component
//public class SchedulingConfig {
//
//	@Autowired
//	private ScrappingService scrappingService;
//	
//	@PostConstruct
//	public void runAfterStart() throws IOException {
//		scrappingService.scrap();
//	}
//	
//	@Scheduled(cron = "* * 2 * * *")//매 2시
//	public void runWhenDawn() throws IOException {
//		scrappingService.scrap();
//	}
//}

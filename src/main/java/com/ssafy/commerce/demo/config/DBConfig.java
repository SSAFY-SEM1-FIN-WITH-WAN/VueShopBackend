package com.ssafy.commerce.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@MapperScan(basePackages = "com.ssafy.commerce.demo.cloth.dao")
@MapperScan(basePackages = "com.ssafy.commerce.demo.model.dao")
public class DBConfig {

}

package com.ssafy.commerce.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@MapperScan(basePackages = "com.ssafy.commerce.demo.user.dao")
@MapperScan(basePackages = "com.ssafy.commerce.demo.board.dao")
@MapperScan(basePackages = "com.ssafy.commerce.demo.comment.dao")
@MapperScan(basePackages = "com.ssafy.commerce.demo.file.dao")
@MapperScan(basePackages = "com.ssafy.commerce.demo.cloth.dao")
public class DBConfig {

}

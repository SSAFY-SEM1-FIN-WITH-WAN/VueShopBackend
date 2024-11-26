package com.ssafy.commerce.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.commerce.demo.interceptor.JwtInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private JwtInterceptor jwtInterceptor;
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(jwtInterceptor)
	        .addPathPatterns("/**")
	        .excludePathPatterns(
        		"/swagger-ui/**",
        		"/v3/api-docs/**",
        		"/api/v1/**",
	            "/api/users/signup",
	            "/api/users/login",
	            "/api/users/password"
	        );
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**")
        	.allowedOriginPatterns("*") // 허용할 출처 : 특정 도메인만 받을 수 있음
        	.allowedMethods("*") // 허용할 HTTP method
        	.allowCredentials(true); // 쿠키 인증 요청 허용
	}
}

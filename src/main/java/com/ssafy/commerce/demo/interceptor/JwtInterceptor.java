package com.ssafy.commerce.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.commerce.demo.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String httpMethod = request.getMethod();
		String httpRequestURI = request.getRequestURI();
		
//		System.out.println("********************************************");
//		System.out.println("********************************************");
//		System.out.println(httpMethod);
//		System.out.println(httpRequestURI);
		
		if (httpMethod.equals("OPTIONS") ||
				httpMethod.equals("GET") && httpRequestURI.startsWith("/api/boards") || 
				httpMethod.equals("GET") && httpRequestURI.startsWith("/api/v1"))
			return true;
		
		String token = request.getHeader("access-token");
		
//		System.out.println(token);
//		System.out.println("********************************************");
//		System.out.println("********************************************");
		
		if (token != null) {
			
			request.setAttribute("accountId", jwtUtil.getAccountIdFromToken(token));
			return true;
		}
		
		throw new Exception("유효하지 않은 접근입니다");
	}
}

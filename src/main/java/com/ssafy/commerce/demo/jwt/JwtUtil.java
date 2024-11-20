package com.ssafy.commerce.demo.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {
	
    @Value("${jwt.token.key}")
	private String serviceKey;
	
    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        this.secretKey = Keys.hmacShaKeyFor(serviceKey.getBytes(StandardCharsets.UTF_8));
    }

	public String createToken(String accountId) {
		
		Date exp = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
		return Jwts.builder()
				.header().add("typ", "JWT").and()	// 헤더
				.claim("accountId", accountId)		// 페이로드
				.expiration(exp)
				.signWith(secretKey)				// 서명
				.compact();
	}
	
	public Jws<Claims> validate(String token) {
		
		try {
			return Jwts.parser()
					.verifyWith(secretKey)
					.build()
					.parseSignedClaims(token);
		} catch (Exception e) {
			throw new IllegalArgumentException("유효하지 않은 토큰입니다");
		}
	}
	
	public String getAccountIdFromToken(String token) {
		
		Jws<Claims> claims = validate(token);
		return claims
				.getPayload()
				.get("accountId", String.class);
	}
}
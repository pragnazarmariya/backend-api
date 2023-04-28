package com.zosh.config;


import java.time.LocalDateTime;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTokenProvider {
	
	public String generateToken(Authentication auth) {
		SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
		
		String jwt=Jwts.builder()
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getDate()+8400000))
				.claim("email",auth.getName())
				.signWith(key)
				.compact();
		
		return jwt;	
	}

}

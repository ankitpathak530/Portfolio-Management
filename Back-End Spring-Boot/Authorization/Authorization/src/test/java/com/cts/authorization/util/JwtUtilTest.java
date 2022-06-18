package com.cts.authorization.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import com.cts.authorization.controller.AuthController;
import com.cts.authorization.exception.UserNotFoundException;
import com.cts.authorization.service.MyUserDetailsService;

@SpringBootTest
public class JwtUtilTest {

	@Autowired
	MyUserDetailsService myUserDetailsService;

	@Autowired
	private AuthController authController;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Test
	void validateTokenTest()
	{
			JwtResponse res = this.generateToken();
			UserDetails userDetails = myUserDetailsService.loadUserByUsername("Ankit");
			Boolean validateToken1 = this.jwtUtil.validateToken(res.getJwttoken(), userDetails);
			
			assertEquals(true, validateToken1);	
	}
	
	
	
	@Test
	void isTokenExpiredTest() {
		JwtResponse res = this.generateToken();
		Date expirationDateFromToken = this.jwtUtil.getExpirationDateFromToken(res.getJwttoken());
		
		assertNotEquals(new Date().getTime(), expirationDateFromToken.getTime());
	}
	
	
	
	// Generating token
		private JwtResponse generateToken() {
			
			JwtRequest jwtRequest = new JwtRequest();
			jwtRequest.setUsername("Ankit");
			jwtRequest.setPassword("1234");

			JwtResponse res = null;
			try {
				ResponseEntity<JwtResponse> createAuthenticationToken = this.authController
						.createAuthenticationToken(jwtRequest);
				 res =  createAuthenticationToken.getBody();
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
			return res;
		}
		
		
}
